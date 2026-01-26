# 430. Flatten a Multilevel Doubly Linked List
# You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

# Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

# Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

# Definition for a Node.
# Definition for a Node.
class Node:
    def __init__(self, val, prev=None, next=None, child=None):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution:
    def flatten(self, head):
        if not head:
            return None
        
        stack = []
        curr = head
        
        while curr:
            if curr.child:
                # Save next sibling if exists
                if curr.next:
                    stack.append(curr.next)
                # Attach child as next
                curr.next = curr.child
                curr.next.prev = curr
                curr.child = None
            
            # FIXED: Move this INSIDE the while loop with proper indentation
            if not curr.next and stack:
                curr.next = stack.pop()
                curr.next.prev = curr
            
            curr = curr.next
        
        return head

def build_test_tree1():
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)
    
    n1.next = n4
    n4.prev = n1
    n4.next = n3
    n3.prev = n4
    n3.next = n2
    n2.prev = n3
    
    n1.child = n2
    n4.child = n5
    
    return n1

def print_list(head):
    curr = head
    result = []
    while curr:
        result.append(str(curr.val))
        curr = curr.next
    print(" -> ".join(result) + " -> null")

def test_flatten():
    sol = Solution()
    
    print("Test 1: Multi-level DLL")
    head1 = build_test_tree1()
    result1 = sol.flatten(head1)
    print_list(result1)  # Expected: 1->2->3->4->5->null
    
    print("\nTest 2: Single node")
    head2 = Node(1)
    result2 = sol.flatten(head2)
    print_list(result2)  # Expected: 1->null

if __name__ == "__main__":
    test_flatten()
