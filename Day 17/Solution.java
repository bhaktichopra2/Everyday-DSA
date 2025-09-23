// 876. Middle of the Linked List
// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        // Build linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        Solution sol = new Solution();
        ListNode mid = sol.middleNode(head);

        // Print result: should print 3 4 5 (second half of list)
        while (mid != null) {
            System.out.print(mid.val + " ");
            mid = mid.next;
        }
        // Output: 3 4 5
    }
}
