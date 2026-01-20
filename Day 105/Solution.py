# 237. Delete Node in a Linked List
# There is a singly-linked list head and we want to delete a node node in it.

# You are given the node to be deleted node. You will not be given access to the first node of head.

# All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.

# Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:

# The value of the given node should not exist in the linked list.
# The number of nodes in the linked list should decrease by one.
# All the values before node should be in the same order.
# All the values after node should be in the same order.
# Custom testing:

# For the input, you should provide the entire linked list head and the node to be given node. node should not be the last node of the list and should be an actual node in the list.
# We will build the linked list and pass the node to your function.
# The output will be the entire list after calling your function.

# ListNode class
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
    
    def __str__(self):
        result = []
        curr = self
        while curr:
            result.append(str(curr.val))
            curr = curr.next
        return " -> ".join(result) + " -> None"

def create_list(values):
    dummy = ListNode(0)
    curr = dummy
    for val in values:
        curr.next = ListNode(val)
        curr = curr.next
    return dummy.next

class Solution:
    def deleteNode(self, node: ListNode) -> None:
        """
        Do not return anything, modify node in-place instead.
        """
        # Copy next node's value
        node.val = node.next.val
        # Bypass next node
        node.next = node.next.next

if __name__ == "__main__":
    sol = Solution()
    
    # Test case: 4→5→1→9, delete node=5
    head = create_list([4,5,1,9])
    print("Original:", head)
    
    node_to_delete = head.next  # Node with value 5
    sol.deleteNode(node_to_delete)
    
    print("After delete:", head)  # 4→1→9
