## Trie
Trie is an efficient data structure used for retrieval of information. 
One of the main application of the trie data structure is when you have to search for a specific string from a large group of words. 

## Advantages
1) With the help of a trie, we can search a word of length 'L' in O(L) time which is way faster than hashing. 
2) Printing all words present in the trie in alphabetical order. 
3) Prefix searching becomes convinient.

## Disadvantage
The Disadvantage is that tries require a lot of memory

## Application
One of the main application of tries is the auto completion of a query in the google search bar.

For very efficient string matching algorithm, refer this: <https://www.geeksforgeeks.org/aho-corasick-algorithm-pattern-searching/>
For more information on tries refer this: <https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3329/>

# Trie over hashmap
With Trie, we can insert and find strings in O(L) time where L represent the length of a single word. This is obviously faster than BST. This is also faster than Hashing because of the ways it is implemented. We do not need to compute any hash function. No collision handling is required

# Hashmap over trie
Trie requires more space than hashmap.
