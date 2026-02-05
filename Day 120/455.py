# 455. Assign Cookies
# Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.

# Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.

class Solution:
    def findContentChildren(self, g: list[int], s: list[int]) -> int:
        # Sort both: kids' hunger & cookies' size
        g.sort()  # g = kids' hunger levels
        s.sort()  # s = cookie sizes
        
        kid = 0        # Current kid
        cookie = 0     # Current cookie
        
        # Two pointers approach
        while kid < len(g) and cookie < len(s):
            # Cookie satisfies this kid?
            if s[cookie] >= g[kid]:
                kid += 1  # Next kid!
            cookie += 1  # Try next cookie
        
        return kid  # Total happy kids

# Test it
if __name__ == "__main__":
    sol = Solution()
    
    # Test case
    g = [1,2,3]  # Kids hunger
    s = [1,1]    # Cookies
    print(f"Happy kids: {sol.findContentChildren(g, s)}")
    # Output: 1
