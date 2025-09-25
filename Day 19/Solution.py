# 92. Reverse Linked List II
# Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        for _ in range(left - 1):
            pre = pre.next
        start = pre.next
        curr = start.next
        for _ in range(right - left):
            nxt = curr.next
            curr.next = pre.next
            pre.next = curr
            curr = nxt
        start.next = curr
        return dummy.next

# Test harness for VS Code
if __name__ == "__main__":
    # Build linked list: 1 → 2 → 3 → 4 → 5
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    sol = Solution()
    result = sol.reverseBetween(head, 2, 4)

    # Print result, should print 1 4 3 2 5
    curr = result
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Output: 1 4 3 2 5
