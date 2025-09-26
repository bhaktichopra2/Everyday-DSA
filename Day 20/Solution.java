// 2487. Remove Nodes From Linked List
// You are given the head of a linked list.

// Remove every node which has a node with a greater value anywhere to the right side of it.

// Return the head of the modified linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeNodes(ListNode head) {
        ListNode revList = reverseList(head);
        ListNode current = revList;
        int max = Integer.MIN_VALUE;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while(current != null){
            if(current.val >= max){
                max = current.val;
                tail.next = current;
                tail = tail.next;
                current = current.next;
                tail.next = null;
            } else {
                current = current.next;
            }
        }
        return reverseList(dummy.next);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null){
            ListNode next_node = current.next;
            current.next = prev;
            prev = current;
            current = next_node;
        }
        return prev;
    }

    // Test harness for VS Code
    public static void main(String[] args){
        // Create linked list: 12 -> 15 -> 10 -> 11 -> 5 -> 6 -> 2 -> 3
        ListNode head = new ListNode(12);
        head.next = new ListNode(15);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(3);

        Solution sol = new Solution();
        ListNode result = sol.removeNodes(head);

        // Print result: should print nodes that remain after removal
        ListNode curr = result;
        while(curr != null){
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // Expected output: 15 11 6 3
    }
}
