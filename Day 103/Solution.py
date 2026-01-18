# 19. Remove Nth Node From End of List
# Given the head of a linked list, remove the nth node from the end of the list and return its head.

from typing import Optional

# ListNode class definition
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
    
    # Helper to print list
    def __str__(self):
        result = []
        curr = self
        while curr:
            result.append(str(curr.val))
            curr = curr.next
        return " -> ".join(result) + " -> None"

def create_list(values):
    """Helper to create linked list from array"""
    dummy = ListNode()
    curr = dummy
    for val in values:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        dummy = ListNode()
        dummy.next = head
        slow = dummy
        fast = dummy
        
        # Move fast n steps ahead
        for i in range(n):
            fast = fast.next
        
        # Move both until fast reaches end
        while fast.next:
            slow = slow.next
            fast = fast.next
        
        # Remove nth node from end
        slow.next = slow.next.next
        
        return dummy.next

if __name__ == "__main__":
    sol = Solution()
    
    # Test case 1: Remove 2nd from end [1,2,3,4,5] n=2 → [1,2,3,5]
    print("Test 1:")
    list1 = create_list([1,2,3,4,5])
    print(f"Original: {list1}")
    result1 = sol.removeNthFromEnd(list1, 2)
    print(f"Result:   {result1}\n")
    
    # Test case 2: Remove last [1,2] n=1 → [1]
    print("Test 2:")
    list2 = create_list([1,2])
    result2 = sol.removeNthFromEnd(list2, 1)
    print(f"Result:   {result2}\n")
    
    # Test case 3: Remove first [1] n=1 → None
    print("Test 3:")
    list3 = create_list([1])
    result3 = sol.removeNthFromEnd(list3, 1)
    print(f"Result:   {result3}")
