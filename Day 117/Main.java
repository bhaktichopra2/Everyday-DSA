// Job Sequencing Problem
// Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.

import java.util.*;

class Job {
    int id, dead, profit;
    Job(int id, int dead, int profit) {
        this.id = id; this.dead = dead; this.profit = profit;
    }
}

class Solution {
    public static int[] JobScheduling(Job[] arr, int n) {
        Arrays.sort(arr, (a, b) -> Integer.compare(b.profit, a.profit));

        int maxi = arr[0].dead;
        for(int i = 1; i < n; i++) {
            maxi = Math.max(maxi, arr[i].dead);
        }

        int[] res = new int[maxi + 1];
        Arrays.fill(res, -1);
        int cnt = 0, totalprofit = 0;

        for(int i = 0; i < n; i++) {
            for(int j = arr[i].dead; j > 0; j--) {
                if(res[j] == -1) {
                    res[j] = arr[i].id;
                    cnt++;
                    totalprofit += arr[i].profit;
                    break;
                }
            }
        }
        return new int[]{cnt, totalprofit};
    }
}

public class Main {
    public static void main(String[] args) {
        int n = 4;
        Job[] jobs = {
            new Job(1, 4, 20),
            new Job(2, 1, 10),
            new Job(3, 2, 40),
            new Job(4, 2, 30)
        };
        
        int[] ans = Solution.JobScheduling(jobs, n);
        System.out.println("Jobs: " + ans[0] + ", Profit: " + ans[1]);
    }
}
