// 234. Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        while (slow != null){
            ListNode np = slow.next;
            slow.next = prev;
            prev = slow;
            slow = np;
        }

        ListNode l = head, r = prev;
        while(r != null){
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }

    // Test harness for VS Code
    public static void main(String[] args){
        // Palindrome: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(head)); // Output: true

        // Non-palindrome: 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println(sol.isPalindrome(head2)); // Output: false
    }
}
