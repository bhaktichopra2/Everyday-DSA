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
from collections import deque

class MyStack:
    def __init__(self):
        self.q1 = deque()
        self.q2 = deque()

    def push(self, x: int) -> None:
        self.q2.append(x)
        while self.q1:
            self.q2.append(self.q1.popleft())
        self.q1, self.q2 = self.q2, self.q1

    def pop(self) -> int:
        if not self.q1:
            raise IndexError("stack is empty")
        return self.q1.popleft()

    def top(self) -> int:
        if not self.q1:
            raise IndexError("stack is empty")
        return self.q1[0]

    def empty(self) -> bool:
        return not self.q1

# Test harness for VS Code
if __name__ == "__main__":
    stack = MyStack()
    stack.push(1)
    stack.push(2)
    print(stack.top())    # Output: 2
    print(stack.pop())    # Output: 2
    print(stack.empty())  # Output: False
