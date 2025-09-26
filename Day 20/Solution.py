# 2487. Remove Nodes From Linked List
# You are given the head of a linked list.

# Remove every node which has a node with a greater value anywhere to the right side of it.

# Return the head of the modified linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        revList = self.reverseList(head)
        current = revList
        max_val = float('-inf')
        dummy = ListNode(0)
        tail = dummy

        while current:
            if current.val >= max_val:
                max_val = current.val
                tail.next = current
                tail = tail.next
                current = current.next
                tail.next = None
            else:
                current = current.next

        return self.reverseList(dummy.next)
    
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None
        current = head
        while current:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        return prev

# Test harness for VS Code
if __name__ == "__main__":
    # Create linked list: 12 → 15 → 10 → 11 → 5 → 6 → 2 → 3
    head = ListNode(12)
    head.next = ListNode(15)
    head.next.next = ListNode(10)
    head.next.next.next = ListNode(11)
    head.next.next.next.next = ListNode(5)
    head.next.next.next.next.next = ListNode(6)
    head.next.next.next.next.next.next = ListNode(2)
    head.next.next.next.next.next.next.next = ListNode(3)

    sol = Solution()
    result = sol.removeNodes(head)

    # Print result
    curr = result
    while curr:
        print(curr.val, end=" ")
        curr = curr.next
    # Expected output: 15 11 6 3
