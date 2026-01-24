# 142. Linked List Cycle II
# Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

# There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

# Do not modify the linked list.

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def detectCycle(self, head):
        if not head or not head.next:
            return None
        
        slow = head
        fast = head
        
        # Phase 1: Detect cycle
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            
            if slow == fast:
                # Phase 2: Find cycle entrance
                slow = head
                while slow != fast:
                    slow = slow.next
                    fast = fast.next
                return slow
        
        return None

# Test function
def create_cycle_list(values, cycle_start_idx):
    if not values:
        return None
    
    head = ListNode(values[0])
    curr = head
    
    for val in values[1:]:
        curr.next = ListNode(val)
        curr = curr.next
    
    # Create cycle
    if cycle_start_idx >= 0 and cycle_start_idx < len(values):
        cycle_start = head
        for i in range(cycle_start_idx):
            cycle_start = cycle_start.next
        curr.next = cycle_start
    
    return head

def test_cycle_detection():
    sol = Solution()
    
    # Test 1: [3,2,0,4], cycle_start=1 → returns node with 2
    head1 = create_cycle_list([3,2,0,4], 1)
    result1 = sol.detectCycle(head1)
    print(f"Cycle at 1: {result1.val if result1 else 'null'}")
    
    # Test 2: [1], cycle_start=0 → returns node with 1
    head2 = create_cycle_list([1], 0)
    result2 = sol.detectCycle(head2)
    print(f"Cycle at 0: {result2.val if result2 else 'null'}")
    
    # Test 3: [1], no cycle → null
    head3 = create_cycle_list([1], -1)
    result3 = sol.detectCycle(head3)
    print(f"No cycle: {'null' if not result3 else result3.val}")

if __name__ == "__main__":
    test_cycle_detection()
