// 21. Merge Two Sorted Lists
// You are given the heads of two sorted linked lists list1 and list2.

// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

// Return the head of the merged linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null || list2 != null) {
            cur.next = (list1 != null) ? list1 : list2;
        }
        return dummy.next;
    }

    // Test harness for VS Code
    public static void main(String[] args) {
        // List1: 1 -> 3 -> 5
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        // List2: 2 -> 4 -> 6
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(l1, l2);

        // Print result: should print 1 2 3 4 5 6
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        // Output: 1 2 3 4 5 6
    }
}
