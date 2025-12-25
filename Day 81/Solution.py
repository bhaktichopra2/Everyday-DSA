# 557. Reverse Words in a String III
# Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
class Solution:
    def reverseWords(self, s: str) -> str:
        # s.split(" ") keeps exact spacing pattern (spaces preserved in between words)
        words = s.split(" ")
        for i in range(len(words)):
            words[i] = words[i][::-1]
        return " ".join(words)

if __name__ == "__main__":
    sol = Solution()
    print(sol.reverseWords("Let's take LeetCode contest"))
    # s'teL ekat edoCteeL tsetnoc
    print(sol.reverseWords("Mr Ding"))
    # rM gniD
