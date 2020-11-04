# Floyd Cycle Detection

## Method 1: Hashing
**Algorithm**: Store the nodes as you traverse and if you reach a node that is already visited, then that node is the starting node of the cycle.
O(n) space for storing nodes, O(n) time for traversal

## Method 2: Floyd Cycle Detection
**Algorithm**: Maintain 2 nodes, fast and slow, where fast moves twice as fast as slow and if the 2 nodes meet, a cycle exists. To find the starting node of the cycle, move any one of the node to the head of the linkedlist and move both fast and slow by 1 unit until those 2 nodes meet. The node where the fast and the slow nodes meet is the starting point of the cycle.

## Why Floyd Detection Algorithm works
