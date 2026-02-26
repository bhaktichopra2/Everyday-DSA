// 225. Implement Stack using Queues
// Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

// Implement the MyStack class:

// void push(int x) Pushes element x to the top of the stack.
// int pop() Removes the element on the top of the stack and returns it.
// int top() Returns the element on the top of the stack.
// boolean empty() Returns true if the stack is empty, false otherwise.
// Notes:

// You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
// Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 
import java.util.*;

// Stack implementation using Queue
class Solution {
    // Queue
    Queue<Integer> q = new LinkedList<>();

    // Method to push element in the stack
    public void push(int x) {
        // Get size
        int s = q.size();
        // Add element
        q.add(x);

        // Move elements before new element to back
        for (int i = 0; i < s; i++) {
            q.add(q.poll());
        }
    }

    // Method to pop element from stack
    public int pop() {
        // Get front element
        int n = q.peek();
        // Remove front element
        q.poll();
        // Return removed element
        return n;
    }

    // Method to return the top of stack
    public int top() {
        // Return front element
        return q.peek();
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        Solution st = new Solution();
        
        // Array of commands
        String[] commands = {"QueueStack", "push", "push", 
                             "pop", "top", "isEmpty"};
        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    st.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(st.pop() + " ");
                    break;
                case "top":
                    System.out.print(st.top() + " ");
                    break;
                case "isEmpty":
                    System.out.print(st.isEmpty() ? "true " : "false ");
                    break;
                case "QueueStack":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
