# 234. Palindrome Linked List
# Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        fast = slow = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        prev = None
        while slow:
            np = slow.next
            slow.next = prev
            prev = slow
            slow = np

        l = head
        r = prev
        while r:
            if l.val != r.val:
                return False
            l = l.next
            r = r.next
        return True

if __name__ == "__main__":
    # Palindrome: 1 -> 2 -> 2 -> 1
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(2)
    head.next.next.next = ListNode(1)
    sol = Solution()
    print(sol.isPalindrome(head)) # Output: True

    # Non-palindrome: 1 -> 2 -> 3
    head2 = ListNode(1)
    head2.next = ListNode(2)
    head2.next.next = ListNode(3)
    print(sol.isPalindrome(head2)) # Output: False
