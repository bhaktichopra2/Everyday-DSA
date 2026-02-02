# Job Sequencing Problem
# Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit. The profit can only be earned upon completing the job within its deadline. Find the number of jobs done and the maximum profit that can be obtained. Each job takes a single unit of time and only one job can be performed at a time.

class Job:
    def __init__(self, id, dead, profit):
        self.id = id
        self.dead = dead
        self.profit = profit

class Solution:
    def jobScheduling(self, jobs):
        # Sort by profit DESC
        jobs.sort(key=lambda j: j.profit, reverse=True)
        
        # Find max deadline
        maxi = max(j.dead for j in jobs)
        
        # Slots array
        slots = [-1] * (maxi + 1)
        cnt = 0
        total_profit = 0
        
        # Greedy assignment
        for job in jobs:
            # Try latest slot <= deadline
            for j in range(job.dead, 0, -1):
                if slots[j] == -1:  # FIXED: was slots[i]
                    slots[j] = job.id
                    cnt += 1
                    total_profit += job.profit
                    break
        
        return cnt, total_profit

# Test
if __name__ == "__main__":
    jobs = [
        Job(1, 4, 20),
        Job(2, 1, 10),
        Job(3, 2, 40),
        Job(4, 2, 30)
    ]
    
    sol = Solution()
    cnt, profit = sol.jobScheduling(jobs)
    print(f"Jobs: {cnt}, Profit: {profit}")  # 3 90
