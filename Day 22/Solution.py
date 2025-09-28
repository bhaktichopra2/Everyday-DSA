# 21. Merge Two Sorted Lists
# You are given the heads of two sorted linked lists list1 and list2.

# Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

# Return the head of the merged linked list.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        cur = dummy = ListNode()
        while list1 and list2:
            if list1.val < list2.val:
                cur.next = list1
                list1, cur = list1.next, list1
            else:
                cur.next = list2
                list2, cur = list2.next, list2
        if list1 or list2:
            cur.next = list1 if list1 else list2
        return dummy.next

if __name__ == "__main__":
    # List1: 1 -> 3 -> 5
    l1 = ListNode(1, ListNode(3, ListNode(5)))
    # List2: 2 -> 4 -> 6
    l2 = ListNode(2, ListNode(4, ListNode(6)))

    sol = Solution()
    merged = sol.mergeTwoLists(l1, l2)

    # Print result: should print 1 2 3 4 5 6
    while merged:
        print(merged.val, end=" ")
        merged = merged.next
    # Output: 1 2 3 4 5 6
