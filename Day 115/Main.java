// There is one meeting room in a firm. You are given two arrays, start and end each of size N. For an index ‘i’, start[i] denotes the starting time of the ith meeting while end[i] will denote the ending time of the ith meeting. Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a particular time. Print the order in which these meetings will be performed.

import java.util.*;

// Class to hold solution logic
class Solution {
    // Function to get all meetings that can be scheduled
    public List<Integer> maxMeetings(int[] start, int[] end) {
        List<int[]> meeting = new ArrayList<>();
        for(int i=0; i<start.length; i++){
            meeting.add(new int[]{end[i], start[i], i+1});
        }

        meeting.sort(Comparator.comparingInt(a -> a[0]));

        List<Integer> res = new ArrayList<>();
        int last = -1;
        for(int[] m : meeting){
            if(m[1] > last){
                res.add(m[2]);
                last = m[0];
            }
        }
        return res;
    }
}

// Separate main class
public class Main {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        Solution sol = new Solution();
        List<Integer> res = sol.maxMeetings(start, end);

        for (int idx : res) {
            System.out.print(idx + " ");
        }
    }
}
