# 876. Middle of the Linked List
# Given the head of a singly linked list, return the middle node of the linked list.

# If there are two middle nodes, return the second middle node.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def middleNode(self, head: Optional[ListNode]) -> Optional[ListNode]:
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        return slow

# Test harness for VS Code
if __name__ == "__main__":
    # Build linked list: 1 -> 2 -> 3 -> 4 -> 5
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    head.next.next.next.next = ListNode(5)

    sol = Solution()
    mid = sol.middleNode(head)

    # Print result: should print 3 4 5 (second half of list)
    current = mid
    while current:
        print(current.val, end=" ")
        current = current.next
    # Output: 3 4 5
