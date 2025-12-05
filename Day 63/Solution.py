# 83. Remove Duplicates from Sorted List
# Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
from typing import Optional

# Definition for singly-linked list node
class ListNode:
    def __init__(self, val: int = 0, next: 'Optional[ListNode]' = None):
        self.val = val
        self.next = next

class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        curr = head
        while curr is not None and curr.next is not None:
            if curr.val == curr.next.val:
                curr.next = curr.next.next
            else:
                curr = curr.next
        return head
