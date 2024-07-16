# Important Algo and Data structures
This repository contains solutions to important problems from leetcode, codechef, codeforces, Interviewbit and Hackerearth. <br/>

# How to Contribute
1. Fork this repository.
2. Write the solution to the problem in your preferred language.
3. Check if the problem folder is available or not (For eg., BFS, DFS etc problems should go into the graphs folder). If the problem folder is not available, then create the folder.
4. Make sure that the code has comments and at the top, the problem link is given.
5. Create Pull Request.

Thanks and Happy Coding!

## Binary Search
Refer this post: https://leetcode.com/discuss/general-discussion/786126/python-powerful-ultimate-binary-search-template-solved-many-problems

Refer solved problems [here](./Binary%20Search/)

Tip: Whenever we have some problems which tells to find `minimised max answer`, try to think `binary search`.

Reference problems:
1. [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/description/)
2. [Divide Chocolate](https://leetcode.ca/all/1231.html)
3. [Length of LIS](https://leetcode.com/problems/longest-increasing-subsequence)
4. [Russian Doll Envelopes](https://leetcode.com/problems/russian-doll-envelopes/)
5. [Find Indices of Ones](./Binary%20Search/FindIndicesOfOnes.java)

## Graphs
Refer this post: https://leetcode.com/discuss/study-guide/1326900/graph-algorithms-problems-to-practice

Refer solved problems [here](./Graphs/)

For 2d points, consider using indexes in adjacency map (Refer [Detonate the Maximum Bombs](./Graphs/2101.%20Detonate%20the%20Maximum%20Bombs.java))

Some more important problems
- [Longest Increasing Path In a Matrix](./Graphs/Longest%20path%20in%20a%20directed%20Acyclic%20graph.java)
- [Maximum Score of a Node Sequence](./Graphs/2242.%20Maximum%20Score%20of%20a%20Node%20Sequence.java)
- [Alien Dictionary](./Graphs/Alien%20Dictionary.java)
- [Maximum Number Of Invitations](./Graphs/Maximum%20Number%20Of%20Invitations%20to%20a%20Party.java)
- [String Replacement Library](./Graphs/StringReplacementLibrary.java)

### DSU complexity analysis

In union method, why do we set the parent which has greater size?

Refer these links
- https://cs.stackexchange.com/questions/82728/in-disjoint-sets-why-do-we-make-the-smaller-tree-the-subtree-of-the-larger-one

- https://stackoverflow.com/questions/53149097/why-is-the-time-complexity-of-performing-n-union-find-union-by-size-operations
```
Let's say we have 2 nodes x and y in the union method

We find the parent and note down the sizes of the groups which have x and y.

Suppose the height of group containing x is heightX and similarly for y, it is heightY.

Case 1: heightX > heightY
If we attach node x to node y, the height would become heightX + 1

But if we attach node y to node x, the height would be height X 

So we attach node y to node x.

Case 2: heightX = heightY
In this case, the height of the resultant set would be heightX + 1
```

## Line Sweep
Refer this post: https://leetcode.com/discuss/study-guide/2166045/line-sweep-algorithms

Refer solved problems [here](./Line%20Sweep/)

Some important problems
- [On Call Rotation Schedule](./Line%20Sweep/OnCallRotationSchedule.java)
- [Non overlapping intervals](https://leetcode.com/problems/non-overlapping-intervals/description/) (Sort by end time)
- [Remove covered intervals](https://leetcode.com/problems/remove-covered-intervals/) (Sort by start time and then by end time in descending order)

## Game theory

Solve problems by keeping the state of the current player. (And we can also remove the current player state if we see that it is not used in the recursive function)

Refer:
- [Nim Game](./Dynamic%20Programming/Game%20Stratergies/292.%20Nim%20Game.java)
- [Divisor Game](./Dynamic%20Programming/Game%20Stratergies/1025.%20Divisor%20Game.java)
- [Stone Game IV](./Dynamic%20Programming/Game%20Stratergies/1510.%20Stone%20Game%20IV.java)
- [Babylon](./Dynamic%20Programming/Game%20Stratergies/Babylon.java)


Solve problems by the `Difference of scores method`

Refer:
- [Predict the winner](./Dynamic%20Programming/Game%20Stratergies/486.%20Predict%20the%20Winner.java)
- [Stone Game I](./Dynamic%20Programming/Game%20Stratergies/877.%20Stone%20Game.java)
- [Stone Game II](./Dynamic%20Programming/Game%20Stratergies/1140.%20Stone%20Game%20II.java)
- [Stone Game III](./Dynamic%20Programming/Game%20Stratergies/1406.%20Stone%20Game%20III.java)
- [Stone Game VII](./Dynamic%20Programming/Game%20Stratergies/1690.%20Stone%20Game%20VII.java)


Solve problems by `sorting and greedy approach` (When the problem says that a player can pick any idx from the array for their score). 

Refer:
- [Stone Game VI](./Dynamic%20Programming/Game%20Stratergies/1686.%20Stone%20Game%20VI.java)
- [Maximum Number Of Coins You Can Get](./Dynamic%20Programming/Game%20Stratergies/1561.%20Maximum%20Number%20of%20Coins%20You%20Can%20Get.java)


Refer solved problems [here](./Dynamic%20Programming/Game%20Stratergies/)

## Priority queue

Refer this post: https://leetcode.com/discuss/study-guide/1360400/priority-queue-problems-to-practice

Refer solved problems [here](./Priority%20Queue/)

Some important problems
- [Reorganise Strings](./Priority%20Queue/767.%20Reorganize%20String.java)
- [Time for turn](./Priority%20Queue/Time%20for%20turn.java)
- [Single threaded CPU](./Priority%20Queue/1834.%20Single-Threaded%20CPU.java)
- [Median in data stream](./Priority%20Queue/295.%20Find%20Median%20from%20Data%20Stream.java)

## Segment tree

Refer this youtube link: [Range Sum Query](https://www.youtube.com/watch?v=dUkRI0R3sg8)

Refer these problems:

- [Count of Smaller Numbers After Self](./Fenwick%20and%20Segment%20trees/315.%20Count%20of%20Smaller%20Numbers%20After%20Self.java)
- [Range Sum Query](./Fenwick%20and%20Segment%20trees/range-sum-query-mutable.java)

## Tries

Refer solved problems [here](./Tries/)

Some important problems

- [Find Selected Directories](./Tries/Find%20Selected%20Directories.java)

## TreeMap / TreeSet

Refer solved problems [here](./TreeMap/) 

Some important problems

- [Find triplets](./TreeMap/Find%20triplets.java)
- [Amount of new area painted each day](./TreeMap/2158.%20Amount%20of%20New%20Area%20Painted%20Each%20Day.java)

## Rate limiting

Refer these posts

- [Fixed Window Counter and Sliding Window Log](https://medium.com/@devenchan/implementing-rate-limiting-in-java-from-scratch-fixed-window-and-sliding-window-implementation-a6e8d6407d17)
- [Leaky Bucket and Token Bucket](https://medium.com/@devenchan/implementing-rate-limiting-in-java-from-scratch-leaky-bucket-and-tokenn-bucket-implementation-63a944ba93aa)

