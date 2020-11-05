## Sorting
### Unstable 
Quicksort, Heap Sort, Selection sort, Shell Sort
### Not in place
Merge Sort

![Sorting characteristics](https://github.com/arhankundu99/Competetive-Coding/blob/master/miscellaneous/Sorting/sort-characteristics.png) <br/>

1) Selection sort requires minimum number of swaps.
2) Merge-Insertion sort requires minimum number of comparisons.
3) To find minimum number of swaps to sort a array calculate using the lengths of the cycle 

## Proof of building a heap in O(n)
![Proof of building a heap in O(n)](https://github.com/arhankundu99/Competetive-Coding/blob/master/miscellaneous/Sorting/Heap%20in%20O(n).jpeg) <br/>

## Binary Heap vs BST
NOTE: The time complexities below are worst case complexities
1) **Searching**: BST takes O(n) time, AVL takes O(logn) time, Heap takes O(n) time
2) **Creation**: Creation of BST O(n^2), AVL takes O(nlogn) time, Heap takes O(n) time as discussed above.
3) **Finding Maximum or minimum element**: BST takes O(n) time, AVL takes O(logn) time, Heap takes O(1) time

Usages: 
1) BST is used in searching algorithms, inorder travarsal gives elements in sorted order, They can be used to represent arithmetic expressions ![Refer this](https://en.wikipedia.org/wiki/Binary_expression_tree). 
2) Heap is used in many algorithms like **Dijkstra**, **Prims**, **Heap Sort**, Finding maximum or minimum element in O(1), Priority Queue etc.
