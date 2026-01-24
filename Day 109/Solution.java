// 142. Linked List Cycle II
// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

// Do not modify the linked list.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { 
        val = x; 
        next = null; 
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Phase 1: Find meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                // Phase 2: Find cycle start
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
     public static ListNode createCycleList(int[] values, int cycleStartIndex) {
        if (values.length == 0) return null;
        
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }
        
        // Create cycle
        if (cycleStartIndex >= 0 && cycleStartIndex < values.length) {
            ListNode cycleStart = head;
            for (int i = 0; i < cycleStartIndex; i++) {
                cycleStart = cycleStart.next;
            }
            curr.next = cycleStart;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1: Cycle at index 1 [3,2,0,4], cycle_start=1
        ListNode head1 = createCycleList(new int[]{3,2,0,4}, 1);
        ListNode result1 = sol.detectCycle(head1);
        System.out.println("Cycle at 1: " + (result1 != null ? result1.val : "null"));
        
        // Test 2: Cycle at index 0 [1], cycle_start=0
        ListNode head2 = createCycleList(new int[]{1}, 0);
        ListNode result2 = sol.detectCycle(head2);
        System.out.println("Cycle at 0: " + (result2 != null ? result2.val : "null"));
        
        // Test 3: No cycle [1]
        ListNode head3 = createCycleList(new int[]{1}, -1);
        ListNode result3 = sol.detectCycle(head3);
        System.out.println("No cycle: " + (result3 != null ? result3.val : "null"));
    }
}
