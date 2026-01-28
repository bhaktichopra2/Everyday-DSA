// 138. Copy List with Random Pointer
// A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

// Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

// For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

// Return the head of the copied linked list.

// The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

// val: an integer representing Node.val
// random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
// Your code will only be given the head of the original linked list.

class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) { this.val = val; this.next = null; this.random = null; }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        insert(head);
        connect(head);
        return deepCopyL(head);
    }

    void insert(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextEle = temp.next;
            Node copy = new Node(temp.val);
            copy.next = nextEle;
            temp.next = copy;
            temp = temp.next.next;
        }
    }

    void connect(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copynode = temp.next;
            copynode.random = (temp.random != null) ? temp.random.next : null;
            temp = temp.next.next;
        }
    }

    Node deepCopyL(Node head) {
        Node temp = head;
        Node dumNode = new Node(-1);
        Node res = dumNode;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dumNode.next;
    }

    // Test + Output
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Test case: 7->13->11->10->1
        // random: 7->null, 13->11, 11->10, 10->null, 1->13
        Node n7 = new Node(7);
        Node n13 = new Node(13); n7.next = n13; n13.random = n7;
        Node n11 = new Node(11); n13.next = n11; n11.random = n13;
        Node n10 = new Node(10); n11.next = n10; n10.random = n11;
        Node n1 = new Node(1); n10.next = n1; n1.random = n13;

        Node copied = sol.copyRandomList(n7);
        
        System.out.println("=== COPIED LIST OUTPUT ===");
        Node temp = copied;
        while (temp != null) {
            String randVal = temp.random != null ? String.valueOf(temp.random.val) : "null";
            System.out.println("Node(" + temp.val + ", random=" + randVal + ")");
            temp = temp.next;
        }
    }
}
