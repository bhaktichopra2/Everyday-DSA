// Implement Queue Using Array

// Problem Statement: Implement a First-In-First-Out (FIFO) queue using an array. The implemented queue should support the following operations: push, dequeue, pop, and isEmpty.

// Implement the ArrayQueue class:

// void push(int x): Adds element x to the end of the queue.
// int pop(): Removes and returns the front element of the queue.
// int peek(): Returns the front element of the queue without removing it.
// boolean isEmpty(): Returns true if the queue is empty, false otherwise.

// Class implementing Queue using Arrays
class Solution {
    // Array to store queue elements
    int[] arr;
    // Indices for start and end of the queue
    int start, end;
    // Current size and maximum size of the queue
    int currSize, maxSize;

    // Constructor
    public Solution() {
        arr = new int[10];
        start = -1;
        end = -1;
        currSize = 0;
        maxSize = 10;
    }

    // Method to push an element into the queue
    public void push(int x) {
        // Check if the queue is full
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }

        // If the queue is empty, initialize start and end
        if (end == -1) {
            start = 0;
            end = 0;
        } 
        else {
            // Circular increment of end
            end = (end + 1) % maxSize;
        }

        arr[end] = x;
        currSize++;
    }

    // Method to pop an element from the queue
    public int pop() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        int popped = arr[start];

        // If the queue has only one element, reset start and end
        if (currSize == 1) {
            start = -1;
            end = -1;
        } 
        else {
            // Circular increment of start
            start = (start + 1) % maxSize;
        }

        currSize--;
        return popped;
    }

    // Method to get the front element of the queue
    public int peek() {
        // Check if the queue is empty
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    // Method to determine whether the queue is empty
    public boolean isEmpty() {
        return (currSize == 0);
    }

    public static void main(String[] args) {
        Solution queue = new Solution();

        String[] commands = {"ArrayQueue", "push", "push", 
                             "peek", "pop", "isEmpty"};
        int[][] inputs = {{}, {5}, {10}, {}, {}, {}};

        for (int i = 0; i < commands.length; ++i) {
            switch (commands[i]) {
                case "push":
                    queue.push(inputs[i][0]);
                    System.out.print("null ");
                    break;
                case "pop":
                    System.out.print(queue.pop() + " ");
                    break;
                case "peek":
                    System.out.print(queue.peek() + " ");
                    break;
                case "isEmpty":
                    System.out.print(queue.isEmpty() ? "true " : "false ");
                    break;
                case "ArrayQueue":
                    System.out.print("null ");
                    break;
            }
        }
    }
}
