// 237. Delete Node in a Linked List
// There is a singly-linked list head and we want to delete a node node in it.

// You are given the node to be deleted node. You will not be given access to the first node of head.

// All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

// Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

// The value of the given node should not exist in the linked list.
// The number of nodes in the linked list should decrease by one.
// All the values before node should be in the same order.
// All the values after node should be in the same order.
// Custom testing:

// For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
// We will build the linked list and pass the node to your function.
// The output will be the entire list after calling your function.

// ListNode class (required for standalone VS Code execution)
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
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
    public void deleteNode(ListNode node) {
        // Copy next node's value into current node
        node.val = node.next.val;
        // Bypass next node (effectively delete it)
        node.next = node.next.next;
    }
    
    // VS Code test helpers
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
        
        // Test case: 4→5→1→9, delete node=5
        ListNode head = createList(new int[]{4,5,1,9});
        System.out.println("Original: " + head);
        
        ListNode nodeToDelete = head.next;  // Node with value 5
        sol.deleteNode(nodeToDelete);
        
        System.out.println("After delete: " + head);  // 4→1→9
    }
}
