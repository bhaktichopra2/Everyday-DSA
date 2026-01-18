// 19. Remove Nth Node From End of List
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    // Helper to print list
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode curr = this;
        while(curr != null) {
            sb.append(curr.val).append(" -> ");
            curr = curr.next;
        }
        sb.append("null");
        return sb.toString();
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast n+1 steps ahead
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both until fast reaches end
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove nth node from end
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case 1: Remove 2nd from end [1,2,3,4,5] n=2 → [1,2,3,5]
        ListNode list1 = createList(new int[]{1,2,3,4,5});
        System.out.println("Original: " + list1);
        System.out.println("Remove 2nd from end: " + sol.removeNthFromEnd(list1, 2));
        
        // Test case 2: Remove last [1,2] n=1 → [1]
        ListNode list2 = createList(new int[]{1,2});
        System.out.println("Remove last: " + sol.removeNthFromEnd(list2, 1));
        
        // Test case 3: Remove first [1] n=1 → null
        ListNode list3 = createList(new int[]{1});
        System.out.println("Remove only node: " + sol.removeNthFromEnd(list3, 1));
    }
}
