# 460. LFU Cache

# Design and implement a data structure for a Least Frequently Used (LFU) cache.

# Implement the LFUCache class:

# LFUCache(int capacity) Initializes the object with the capacity of the data structure.
# int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
# void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
# To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

# When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

# The functions get and put must each run in O(1) average time complexity.

# To implement a node in doubly linked 
# list that will store data items
class Node:
   def __init__(self, _key, _value):
       self.key = _key
       self.value = _value
       self.cnt = 1
       self.next = None
       self.prev = None

# To implement the doubly linked list
class List:
   def __init__(self):
       self.size = 0  # Size 
       self.head = Node(0, 0)  # Dummy head
       self.tail = Node(0, 0)  # Dummy tail
       self.head.next = self.tail
       self.tail.prev = self.head

   # Function to add node in front 
   def addFront(self, node):
       temp = self.head.next
       node.next = temp
       node.prev = self.head
       self.head.next = node
       temp.prev = node
       self.size += 1

   # Function to remove node from the list
   def removeNode(self, delnode):
       prevNode = delnode.prev
       nextNode = delnode.next
       prevNode.next = nextNode
       nextNode.prev = prevNode
       self.size -= 1

# Class to implement LFU cache
class LFUCache:
   def __init__(self, capacity):
       # Set the capacity
       self.maxSizeCache = capacity
       self.minFreq = 0  # Set minimum frequency
       self.curSize = 0  # Set current frequency
       
       # Hashmap to store the key-nodes pairs
       self.keyNode = {}  
       
       # Hashmap to maintain the lists 
       # having different frequencies
       self.freqListMap = {}

   # Method to update frequency of data-items
   def updateFreqListMap(self, node):
       # Remove from Hashmap
       del self.keyNode[node.key]
       
       # Update the frequency list hashmap
       self.freqListMap[node.cnt].removeNode(node)
       
       # If node was the last node having its frequency
       if (node.cnt == self.minFreq and 
           self.freqListMap[node.cnt].size == 0):
               
           # Update the minimum frequency
           self.minFreq += 1
       
       # Creating a dummy list for next higher frequency
       nextHigherFreqList = List()
       
       # If the next higher frequency list already exists
       if node.cnt + 1 in self.freqListMap:
           
           # Update pointer to already existing list
           nextHigherFreqList = self.freqListMap[node.cnt + 1]
       
       # Increment the count of data-item
       node.cnt += 1
       
       # Add the node in front of higher frequency list
       nextHigherFreqList.addFront(node)
       
       # Update the frequency list map
       self.freqListMap[node.cnt] = nextHigherFreqList
       self.keyNode[node.key] = node

   # Method to get the value of key from LFU cache
   def get(self, key):
       # Return the value if key exists
       if key in self.keyNode:
           node = self.keyNode[key]  # Get the node
           val = node.value  # Get the value
           self.updateFreqListMap(node)  # Update the frequency
           # Return the value
           return val
           
       # Return -1 if key is not found
       return -1

   def put(self, key, value):
       
       # If the size of Cache is 0, 
       # no data-items can be inserted
       if self.maxSizeCache == 0:
           return
       
       # If key already exists
       if key in self.keyNode:
           node = self.keyNode[key]  # Get the node
           node.value = value  # Update the value
           self.updateFreqListMap(node)  # Update the frequency
       else:
           # If cache limit is reached
           if self.curSize == self.maxSizeCache:
               # Remove the least frequently used data-item
               list = self.freqListMap[self.minFreq]
               del self.keyNode[list.tail.prev.key]
               # Update the frequency map
               self.freqListMap[self.minFreq].removeNode(list.tail.prev)
               self.curSize -= 1  # Decrement the current size of cache
           
           self.curSize += 1  # Increment the current cache size
           # Adding new value to the cache, 
           # set its frequency to 1
           self.minFreq = 1  
           
           # Create a dummy list
           listFreq = List()
           
           # If the list already exists
           if self.minFreq in self.freqListMap:
               
               # Update the pointer to already present list
               listFreq = self.freqListMap[self.minFreq]
           
           # Create the node to store data-item
           node = Node(key, value)
           
           # Add the node to dummy list
           listFreq.addFront(node)
           
           # Add the node to Hashmap
           self.keyNode[key] = node
           
           # Update the frequency list map
           self.freqListMap[self.minFreq] = listFreq

# LFU Cache
cache = LFUCache(2)

# Queries
cache.put(1, 1)
cache.put(2, 2)
print(cache.get(1), end=" ")
cache.put(3, 3)
print(cache.get(2), end=" ")
print(cache.get(3), end=" ")
cache.put(4, 4)
print(cache.get(1), end=" ")
print(cache.get(3), end=" ")
print(cache.get(4), end=" ")