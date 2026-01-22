# 25. Reverse Nodes in k-Group
# Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

# k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

# You may not alter the values in the list's nodes, only nodes themselves may be changed.
from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
    def __str__(self):
        result = []
        curr = self
        while curr:
            result.append(str(curr.val))
            curr = curr.next
        return " -> ".join(result) + " -> None"

def create_list(values):
    dummy = ListNode(0)
    curr = dummy
    for val in values:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        if not head or k == 1:
            return head
        
        dummy = ListNode(0)
        dummy.next = head
        
        cur = dummy
        pre = dummy
        nex = dummy
        count = 0
        
        # Count total nodes
        while cur.next:
            cur = cur.next
            count += 1
        
        while count >= k:
            cur = pre.next
            nex = cur.next
            
            # Reverse k nodes
            for i in range(1, k):
                cur.next = nex.next
                nex.next = pre.next
                pre.next = nex
                nex = cur.next
            
            pre = cur
            count -= k
        
        return dummy.next

if __name__ == "__main__":
    sol = Solution()
    
    # Test 1: 1→2→3→4→5, k=2 → 2→1→4→3→5
    head1 = create_list([1,2,3,4,5])
    print("Original: ", head1)
    print("k=2:      ", sol.reverseKGroup(head1, 2))
    print()
    
    # Test 2: 1→2→3→4→5, k=3 → 3→2→1→4→5
    head2 = create_list([1,2,3,4,5])
    print("k=3:      ", sol.reverseKGroup(head2, 3))
