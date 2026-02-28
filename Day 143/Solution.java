// 146. LRU Cache

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

import java.util.HashMap;

public class Solution {

    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    public Solution(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        remove(node);
        insertAtFront(node);
        return node.value;
    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insertAtFront(node);
            return;
        }

        if (map.size() == capacity) {
            Node lru = tail.prev;
            map.remove(lru.key);
            remove(lru);
        }

        Node newNode = new Node(key, value);
        insertAtFront(newNode);
        map.put(key, newNode);
    }

    private void insertAtFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // ---- Test main for VS Code ----
    public static void main(String[] args) {
        Solution cache = new Solution(2);

        cache.put(2, 6);
        System.out.println(cache.get(2)); // 6

        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1)); // 2
        System.out.println(cache.get(2)); // 6
    }
}