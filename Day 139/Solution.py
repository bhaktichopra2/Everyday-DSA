# Implement Stack using Array

# Problem Statement: Implement a Last-In-First-Out (LIFO) stack using an array. The implemented stack should support the following operations: push, pop, peek, and isEmpty.

# Implement the ArrayStack class:

# void push(int x): Pushes element x onto the stack. int pop(): Removes and returns the top element of the stack. int top(): Returns the top element of the stack without removing it. boolean isEmpty(): Returns true if the stack is empty, false otherwise.

class ArrayStack:
    # Constructor
    def __init__(self, size=1000):
        # Array to hold elements
        self.stackArray = [0] * size
        # Maximum capacity
        self.capacity = size
        # Initialize stack as empty
        self.topIndex = -1

    # Pushes element x
    def push(self, x):
        if self.topIndex >= self.capacity - 1:
            print("Stack overflow")
            return
        self.topIndex += 1
        self.stackArray[self.topIndex] = x

    # Removes and returns top element
    def pop(self):
        if self.isEmpty():
            print("Stack is empty")
            # Return invalid value
            return -1
        top_element = self.stackArray[self.topIndex]
        self.topIndex -= 1
        return top_element

    # Returns top element
    def top(self):
        if self.isEmpty():
            print("Stack is empty")
            return -1
        return self.stackArray[self.topIndex]

    '''Returns true if the 
       stack is empty, false otherwise'''
    def isEmpty(self):
        return self.topIndex == -1

# Main function
if __name__ == "__main__":
    stack = ArrayStack()
    commands = ["ArrayStack", "push", "push", "top", "pop", "isEmpty"]
    inputs = [[], [5], [10], [], [], []]

    for i in range(len(commands)):
        if commands[i] == "push":
            stack.push(inputs[i][0])
            print("null", end=" ")
        elif commands[i] == "pop":
            print(stack.pop(), end=" ")
        elif commands[i] == "top":
            print(stack.top(), end=" ")
        elif commands[i] == "isEmpty":
            print("true" if stack.isEmpty() else "false", end=" ")
        elif commands[i] == "ArrayStack":
            print("null", end=" ")