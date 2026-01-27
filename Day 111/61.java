// 61. Rotate List
// Given the head of a linked list, rotate the list to the right by k places.

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution{
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        tail.next = head;
        
        int rotations = k % length;
        ListNode newTail = head;
        for (int i = 0; i < length - rotations - 1; i++) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1: [1,2,3,4,5], k=2 → [4,5,1,2,3]
        ListNode head1 = buildList(new int[]{1,2,3,4,5});
        ListNode result1 = sol.rotateRight(head1, 2);
        printList("Test 1 (k=2)", result1);
        
        // Test 2: [0,1,2], k=4 → [2,0,1]  
        ListNode head2 = buildList(new int[]{0,1,2});
        ListNode result2 = sol.rotateRight(head2, 4);
        printList("Test 2 (k=4)", result2);
    }
    
    static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }
    
    static void printList(String testName, ListNode head) {
        System.out.print(testName + ": ");
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
