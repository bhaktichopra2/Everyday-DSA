// 83. Remove Duplicates from Sorted List
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
import java.util.*;

// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        // Test: 1->2->3->3->4->4->5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        
        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);
        
        // Print result: 1->2->3->4->5
        System.out.print("Result: ");
        ListNode temp = result;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

