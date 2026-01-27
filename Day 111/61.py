# 61. Rotate List
# Given the head of a linked list, rotate the list to the right by k places.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head, k):
        if not head or not head.next or k == 0:
            return head
        
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1
        
        tail.next = head
        
        rotations = k % length
        newTail = head
        for i in range(length - rotations - 1):
            newTail = newTail.next
        
        newHead = newTail.next
        newTail.next = None
        
        return newHead

def build_list(vals):
    dummy = ListNode(0)
    curr = dummy
    for v in vals:
        curr.next = ListNode(v)
        curr = curr.next
    return dummy.next

def print_list(test_name, head):
    print(f"{test_name}: ", end="")
    curr = head
    result = []
    while curr:
        result.append(str(curr.val))
        curr = curr.next
    print(" -> ".join(result) + " -> null")

def main():
    sol = Solution()
    
    # Test 1: [1,2,3,4,5], k=2 → [4,5,1,2,3]
    head1 = build_list([1,2,3,4,5])
    result1 = sol.rotateRight(head1, 2)
    print_list("Test 1 (k=2)", result1)
    
    # Test 2: [0,1,2], k=4 → [2,0,1]
    head2 = build_list([0,1,2])
    result2 = sol.rotateRight(head2, 4)
    print_list("Test 2 (k=4)", result2)

if __name__ == "__main__":
    main()
