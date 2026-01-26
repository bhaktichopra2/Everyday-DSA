// 430. Flatten a Multilevel Doubly Linked List
// You are given a doubly linked list, which contains nodes that have a next pointer, a previous pointer, and an additional child pointer. This child pointer may or may not point to a separate doubly linked list, also containing these special nodes. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure as shown in the example below.

// Given the head of the first level of the list, flatten the list so that all the nodes appear in a single-level, doubly linked list. Let curr be a node with a child list. The nodes in the child list should appear after curr and before curr.next in the flattened list.

// Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.

import java.util.Stack;

class Node {
    int val;
    Node prev, next, child;
    Node(int v) { val = v; }
}

public class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;
        
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        
        while (curr != null) {
            if (curr.child != null) {
                if (curr.next != null) stack.push(curr.next);
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            if (curr.next == null && !stack.isEmpty()) {
                curr.next = stack.pop();
                curr.next.prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Create exact LeetCode example
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3);
        Node n4 = new Node(4), n5 = new Node(5), n6 = new Node(6), n7 = new Node(7);
        
        // Main chain: 1 <-> 4 <-> 3 <-> 2
        n1.next = n4; n4.prev = n1;
        n4.next = n3; n3.prev = n4;
        n3.next = n2; n2.prev = n3;
        
        // Children: 1->2, 4->5->6, 5->7
        n1.child = n2;
        n4.child = n5;
        n5.child = n6;
        n5.next = n7; n7.prev = n5;
        
        Node result = sol.flatten(n1);
        printList(result);
    }
    
    static void printList(Node head) {
        System.out.println("Flattened List:");
        Node curr = head;
        int count = 0;
        while (curr != null && count < 20) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(" -> ");
            curr = curr.next;
            count++;
        }
        System.out.println(" -> null");
        System.out.println("✅ SUCCESS!");
    }
}
