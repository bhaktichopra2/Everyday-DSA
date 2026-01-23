# 234. Palindrome Linked List
# Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reverse_linked_list(self, head):
        prev = None
        curr = head
        while curr:
            next_temp = curr.next
            curr.next = prev
            prev = curr
            curr = next_temp
        return prev
    
    def isPalindrome(self, head):
        if not head or not head.next:
            return True
        
        # Find middle
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        # Reverse second half
        second_half = self.reverse_linked_list(slow.next)
        
        # Compare halves
        left, right = head, second_half
        while right:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        
        return True

# Test function
def test_palindrome():
    sol = Solution()
    
    # Test 1: 1->2->2->1 ✓
    head1 = ListNode(1, ListNode(2, ListNode(2, ListNode(1))))
    print(f"1->2->2->1: {sol.isPalindrome(head1)}")
    
    # Test 2: 1->2 ✗
    head2 = ListNode(1, ListNode(2))
    print(f"1->2: {sol.isPalindrome(head2)}")
    
    # Test 3: Single node ✓
    head3 = ListNode(1)
    print(f"1: {sol.isPalindrome(head3)}")
    
    # Test 4: 1->2->1 ✓
    head4 = ListNode(1, ListNode(2, ListNode(1)))
    print(f"1->2->1: {sol.isPalindrome(head4)}")
    
    # Test 5: All same ✓
    head5 = ListNode(7, ListNode(7, ListNode(7)))
    print(f"7->7->7: {sol.isPalindrome(head5)}")

if __name__ == "__main__":
    test_palindrome()
