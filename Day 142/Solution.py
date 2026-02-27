# 232. Implement Queue using Stacks

# Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).

# Implement the MyQueue class:

# void push(int x) Pushes element x to the back of the queue.
# int pop() Removes the element from the front of the queue and returns it.
# int peek() Returns the element at the front of the queue.
# boolean empty() Returns true if the queue is empty, false otherwise.
# Notes:

# You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
# Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.

class Solution:

    def __init__(self):
        self.s1 = []
        self.s2 = []

    def push(self, x: int) -> None:
        # Move all elements from s1 to s2
        while self.s1:
            self.s2.append(self.s1.pop())

        # Push new element
        self.s1.append(x)

        # Move everything back to s1
        while self.s2:
            self.s1.append(self.s2.pop())

    def pop(self) -> int:
        return self.s1.pop()

    def peek(self) -> int:
        return self.s1[-1]

    def empty(self) -> bool:
        return not self.s1


# ---- Test block for VS Code ----
if __name__ == "__main__":
    obj = Solution()
    obj.push(10)
    obj.push(20)
    obj.push(30)

    print(obj.pop())    # 10
    print(obj.peek())   # 20
    print(obj.empty())  # False