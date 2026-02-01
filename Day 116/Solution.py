# Minimum number of platforms required for a railway
# Problem Statement: We are given two arrays that represent the arrival and departure times of trains that stop at the platform. We need to find the minimum number of platforms needed at the railway station so that no train has to wait.

class Solution:
    def countPlatforms(self, arr, dep, n):
        # Sort both lists
        arr.sort()
        dep.sort()

        # Initialize pointers and counters
        platforms = 1
        result = 1
        i, j = 1, 0

        # Traverse arrival and departure
        while i < n and j < n:
            # If train arrives before previous departs
            if arr[i] <= dep[j]:
                platforms += 1
                i += 1
            else:
                platforms -= 1
                j += 1

            # Update max platform count
            result = max(result, platforms)

        return result

# Driver code
arr = [900, 945, 955, 1100, 1500, 1800]
dep = [920, 1200, 1130, 1150, 1900, 2000]
n = len(arr)

obj = Solution()
print("Minimum number of Platforms required",
      obj.countPlatforms(arr, dep, n))
