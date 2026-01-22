// 25. Reverse Nodes in k-Group
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

// You may not alter the values in the list's nodes, only nodes themselves may be changed.

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
    
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode cur = dummy, pre = dummy, nex = dummy;
        int count = 0;
        
        // Count total nodes
        while(cur.next != null) {
            cur = cur.next;
            count++;
        }
        
        while(count >= k) {
            cur = pre.next;
            nex = cur.next;
            
            for(int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }
    
    // Test helpers
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for(int val : values) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1: 1→2→3→4→5, k=2 → 2→1→4→3→5
        ListNode head1 = createList(new int[]{1,2,3,4,5});
        System.out.println("Original: " + head1);
        System.out.println("k=2:      " + sol.reverseKGroup(head1, 2));
        System.out.println();
        
        // Test 2: k=3 → 3→2→1→4→5
        ListNode head2 = createList(new int[]{1,2,3,4,5});
        System.out.println("k=3:      " + sol.reverseKGroup(head2, 3));
    }
}
