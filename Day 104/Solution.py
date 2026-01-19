# 2. Add Two Numbers
# You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

# You may assume the two numbers do not contain any leading zero, except the number 0 itself.


from typing import Optional

# ListNode class
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
    dummy = ListNode()
    curr = dummy
    for val in values:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        temp = dummy
        carry = 0
        
        while l1 or l2 or carry:
            sum_val = 0
            if l1:
                sum_val += l1.val
                l1 = l1.next
            if l2:
                sum_val += l2.val
                l2 = l2.next
            
            sum_val += carry
            carry = sum_val // 10
            
            node = ListNode(sum_val % 10)
            temp.next = node
            temp = temp.next
        
        return dummy.next

if __name__ == "__main__":
    sol = Solution()
    
    # 342 + 465 = 807
    l1 = create_list([2,4,3])
    l2 = create_list([5,6,4])
    print("342 + 465 =", sol.addTwoNumbers(l1, l2))
    
    # 999 + 1 = 1000
    l1 = create_list([9,9,9])
    l2 = create_list([1])
    print("999 + 1 =", sol.addTwoNumbers(l1, l2))
