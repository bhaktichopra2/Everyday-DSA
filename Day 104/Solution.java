// 2. Add Two Numbers
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// ListNode class (required for VS Code)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            sum += carry;
            carry = sum / 10;
            
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
    
    // Test helpers
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
        
        // 342 + 465 = 807
        ListNode l1 = createList(new int[]{2,4,3});
        ListNode l2 = createList(new int[]{5,6,4});
        System.out.println("342 + 465 = " + sol.addTwoNumbers(l1, l2));
        
        // 999 + 1 = 1000
        l1 = createList(new int[]{9,9,9});
        l2 = createList(new int[]{1});
        System.out.println("999 + 1 = " + sol.addTwoNumbers(l1, l2));
    }
}
