# Aggressive Cows : Detailed Solution

# Problem Statement: You are given an array 'arr' of size 'n' which denotes the position of stalls. You are also given an integer 'k' which denotes the number of aggressive cows.
# You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible. Find the maximum possible minimum distance.

class Solution:
    # Function to check if cows can be placed with distance d
    def canPlace(self, stalls, cows, d):
        # Place first cow at first stall
        count = 1
        lastPos = stalls[0]

        # Loop through stalls
        for i in range(1, len(stalls)):
            # If stall is at least d away from last placed cow
            if stalls[i] - lastPos >= d:
                # Place cow here
                count += 1
                # Update last position
                lastPos = stalls[i]
            # If all cows placed
            if count >= cows:
                return True
        # Could not place all cows
        return False

    # Function to maximize minimum distance
    def aggressiveCows(self, stalls, cows):
        # Sort stalls
        stalls.sort()

        # Define search space
        low = 1
        high = stalls[-1] - stalls[0]
        ans = 0

        # Binary search
        while low <= high:
            # Find mid distance
            mid = (low + high) // 2

            # If placement possible
            if self.canPlace(stalls, cows, mid):
                # Store answer
                ans = mid
                # Try larger distance
                low = mid + 1
            else:
                # Try smaller distance
                high = mid - 1

        # Return result
        return ans


# Driver code
stalls = [1, 2, 8, 4, 9]
cows = 3
obj = Solution()
print(obj.aggressiveCows(stalls, cows))
