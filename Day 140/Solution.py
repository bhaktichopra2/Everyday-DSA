# Implement Queue Using Array

# Problem Statement: Implement a First-In-First-Out (FIFO) queue using an array. The implemented queue should support the following operations: push, dequeue, pop, and isEmpty.

# Implement the ArrayQueue class:

# void push(int x): Adds element x to the end of the queue.
# int pop(): Removes and returns the front element of the queue.
# int peek(): Returns the front element of the queue without removing it.
# boolean isEmpty(): Returns true if the queue is empty, false otherwise.

# Class implementing Queue using Arrays
class ArrayQueue:
    # Constructor
    def __init__(self):
        # Array to store queue elements
        self.arr = [0] * 10
        # Indices for start and end of the queue
        self.start = -1
        self.end = -1
        # Current size and maximum size of the queue
        self.currSize = 0
        self.maxSize = 10

    # Method to push an element into the queue
    def push(self, x):
        # Check if the queue is full
        if self.currSize == self.maxSize:
            print("Queue is full\nExiting...")
            exit(1)

        # If the queue is empty, initialize start and end
        if self.end == -1:
            self.start = 0
            self.end = 0
        else:
            # Circular increment of end
            self.end = (self.end + 1) % self.maxSize

        self.arr[self.end] = x
        self.currSize += 1

    # Method to pop an element from the queue
    def pop(self):
        # Check if the queue is empty
        if self.start == -1:
            print("Queue Empty\nExiting...")
            exit(1)
        popped = self.arr[self.start]

        # If the queue has only one element, reset start and end
        if self.currSize == 1:
            self.start = -1
            self.end = -1
        else:
            # Circular increment of start
            self.start = (self.start + 1) % self.maxSize

        self.currSize -= 1
        return popped

    # Method to get the front element of the queue
    def peek(self):
        # Check if the queue is empty
        if self.start == -1:
            print("Queue is Empty")
            exit(1)
        return self.arr[self.start]

    # Method to determine whether the queue is empty
    def isEmpty(self):
        return self.currSize == 0


if __name__ == "__main__":
    queue = ArrayQueue()
    commands = ["ArrayQueue", "push", "push", "peek", "pop", "isEmpty"]
    inputs = [[], [5], [10], [], [], []]

    for i in range(len(commands)):
        if commands[i] == "push":
            queue.push(inputs[i][0])
            print("null", end=" ")
        elif commands[i] == "pop":
            print(queue.pop(), end=" ")
        elif commands[i] == "peek":
            print(queue.peek(), end=" ")
        elif commands[i] == "isEmpty":
            print("true" if queue.isEmpty() else "false", end=" ")
        elif commands[i] == "ArrayQueue":
            print("null", end=" ")