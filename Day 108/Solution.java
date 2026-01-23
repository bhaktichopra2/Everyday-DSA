// 234. Palindrome Linked List
// Given the head of a singly linked list, return true if it is a palindrome or false otherwise.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    private ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // Find middle
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseIterative(slow.next);
        
        // Compare halves
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    public static ListNode buildList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test 1: 1->2->2->1 ✓
        ListNode head1 = buildList(new int[]{1,2,2,1});
        System.out.println("1->2->2->1: " + sol.isPalindrome(head1));
        
        // Test 2: 1->2 ✗
        ListNode head2 = buildList(new int[]{1,2});
        System.out.println("1->2: " + sol.isPalindrome(head2));
        
        // Test 3: Single node ✓
        ListNode head3 = buildList(new int[]{1});
        System.out.println("1: " + sol.isPalindrome(head3));
        
        // Test 4: 1->2->1 ✓
        ListNode head4 = buildList(new int[]{1,2,1});
        System.out.println("1->2->1: " + sol.isPalindrome(head4));
        
        // Test 5: All same ✓
        ListNode head5 = buildList(new int[]{7,7,7});
        System.out.println("7->7->7: " + sol.isPalindrome(head5));
    }
}
