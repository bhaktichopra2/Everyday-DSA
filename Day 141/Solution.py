# 225. Implement Stack using Queues
# Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

# Implement the MyStack class:

# void push(int x) Pushes element x to the top of the stack.
# int pop() Removes the element on the top of the stack and returns it.
# int top() Returns the element on the top of the stack.
# boolean empty() Returns true if the stack is empty, false otherwise.
# Notes:

# You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
# Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.
 

from queue import Queue

# Stack implementation using Queue
class QueueStack:
    def __init__(self):
        # Queue
        self.q = Queue()

    # Method to push element in the stack
    def push(self, x):
        # Get size
        s = self.q.qsize()
        # Add element
        self.q.put(x)

        # Move elements before new element to back
        for _ in range(s):
            self.q.put(self.q.get())

    # Method to pop element from stack
    def pop(self):
        # Get front element
        n = self.q.queue[0]
        # Remove front element
        self.q.get()
        # Return removed element
        return n

    # Method to return the top of stack
    def top(self):
        # Return front element
        return self.q.queue[0]

    # Method to check if the stack is empty
    def isEmpty(self):
        return self.q.empty()

if __name__ == "__main__":
    st = QueueStack()

    # List of commands
    commands = ["QueueStack", "push", "push", "pop", "top", "isEmpty"]
    inputs = [[], [4], [8], [], [], []]

    for i in range(len(commands)):
        if commands[i] == "push":
            st.push(inputs[i][0])
            print("null", end=" ")
        elif commands[i] == "pop":
            print(st.pop(), end=" ")
        elif commands[i] == "top":
            print(st.top(), end=" ")
        elif commands[i] == "isEmpty":
            print("true" if st.isEmpty() else "false", end=" ")
        elif commands[i] == "QueueStack":
            print("null", end=" ")