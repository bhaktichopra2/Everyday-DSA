# 146. LRU Cache

# Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

# Implement the LRUCache class:

# LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
# int get(int key) Return the value of the key if the key exists, otherwise return -1.
# void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
# The functions get and put must each run in O(1) average time complexity.

class LRUCache:

    class Node:
        def __init__(self, key, value):
            self.key = key
            self.value = value
            self.prev = None
            self.next = None

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}

        self.head = self.Node(0, 0)
        self.tail = self.Node(0, 0)

        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1

        node = self.map[key]
        self._remove(node)
        self._insert_at_front(node)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            node = self.map[key]
            node.value = value
            self._remove(node)
            self._insert_at_front(node)
            return

        if len(self.map) == self.capacity:
            lru = self.tail.prev
            del self.map[lru.key]
            self._remove(lru)

        new_node = self.Node(key, value)
        self._insert_at_front(new_node)
        self.map[key] = new_node

    def _insert_at_front(self, node):
        node.next = self.head.next
        node.prev = self.head
        self.head.next.prev = node
        self.head.next = node

    def _remove(self, node):
        node.prev.next = node.next
        node.next.prev = node.prev


# ---- Test block for VS Code ----
if __name__ == "__main__":
    cache = LRUCache(2)

    cache.put(2, 6)
    print(cache.get(2))  # 6

    cache.put(1, 5)
    cache.put(1, 2)
    print(cache.get(1))  # 2
    print(cache.get(2))  # 6