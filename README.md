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
6. [Find minimum in rotated array](./Binary%20Search/find%20minimum%20in%20a%20rotated%20search%20array.java)
7. [Random Pick With Weight](./Binary%20Search/Random%20pick%20with%20weight(VVIP).java)
8. [Number of triplets](./Binary%20Search/Number%20of%20triplets.java)
9. [Find the safest path in the grid](./Graphs/2812.%20Find%20the%20Safest%20Path%20in%20a%20Grid.java)

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
- [Number of Islands II](./Disjoint%20Set%20Data%20Structures/Number%20of%20Islands%20II.java)
- [Maximum Minimum Path](./Graphs/Shortest%20Path%20Algorithms/1102%20-%20Path%20With%20Maximum%20Minimum%20Value.java)
- [Path with Maximum Probability](./Graphs/Shortest%20Path%20Algorithms/1514.%20Path%20with%20Maximum%20Probability.java)
- [Critical connections in a network](./Graphs/1192.%20Critical%20Connections%20in%20a%20Network(VVIP).java)
- [Find the safest path in the grid](./Graphs/2812.%20Find%20the%20Safest%20Path%20in%20a%20Grid.java)

Notice the use of max heap in `Maximum Minimum Path` and `Path with Maximum Probability`.

### Bipartite matching
- [Maximum number of accepted invitations](./Graphs/Maximum%20Number%20Of%20Invitations%20to%20a%20Party.java)
- [Question To Volunteer Mapping](./Graphs/Question%20To%20Volunteer%20Mapping.java)

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
- [Remove covered intervals](https://leetcode.com/problems/remove-covered-intervals/) (Sort by start time and then by end time in descending order)
- [Maximum number of overlap](./Line%20Sweep/Maximum%20number%20of%20overlap.java)

### Sort by end time problems
- [Non overlapping intervals](https://leetcode.com/problems/non-overlapping-intervals/description/) (Sort by end time)
- [Minimum Number of Arrows to Burst Balloons](./Line%20Sweep/452.%20Minimum%20Number%20of%20Arrows%20to%20Burst%20Balloons.java)
- [Maximum Length of Pair Chain](./Line%20Sweep/646.%20Maximum%20Length%20of%20Pair%20Chain.java)

### Interval problems
- [Insert interval](./Line%20Sweep/57.%20Insert%20Interval.java)
- [Remove interval](./Line%20Sweep/1272.%20Remove%20Interval.java)

## Game theory

Solve problems by keeping the state of the current player. (And we can also remove the current player state if we see that it is not used in the recursive function)

Refer:
- [Nim Game](./Dynamic%20Programming/Game%20Stratergies/292.%20Nim%20Game.java)
- [Divisor Game](./Dynamic%20Programming/Game%20Stratergies/1025.%20Divisor%20Game.java)
- [Stone Game IV](./Dynamic%20Programming/Game%20Stratergies/1510.%20Stone%20Game%20IV.java)
- [Babylon](./Dynamic%20Programming/Game%20Stratergies/Babylon.java)
- [Candies Game](./Dynamic%20Programming/Game%20Stratergies/Candies%20Game.java)


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
- [Maximum Number of Events That Can Be Attended](./Priority%20Queue/1353.%20Maximum%20Number%20of%20Events%20That%20Can%20Be%20Attended.java)

`Single Threaded CPU` and `Maximum Number of Events that can be attended` are similar.

## Segment tree

Refer this youtube link: [Range Sum Query](https://www.youtube.com/watch?v=dUkRI0R3sg8)

Refer these problems:

- [Count of Smaller Numbers After Self](./Fenwick%20and%20Segment%20trees/315.%20Count%20of%20Smaller%20Numbers%20After%20Self.java)
- [Range Sum Query](./Fenwick%20and%20Segment%20trees/range-sum-query-mutable.java)

## Tries

Refer solved problems [here](./Tries/)

Some important problems

- [Find Selected Directories](./Tries/Find%20Selected%20Directories.java)
- [Byte sequence not in substring](./Tries/Byte%20sequence%20not%20in%20substring.java)

## TreeMap / TreeSet

Refer solved problems [here](./TreeMap/) 

Some important problems

- [Find triplets](./TreeMap/Find%20triplets.java)
- [My Calendar I](./TreeMap/My%20Calendar%201.java)
- [Amount of new area painted each day](./TreeMap/2158.%20Amount%20of%20New%20Area%20Painted%20Each%20Day.java)

## Binary tree

Refer solved problems [here](./Trees/)

Some important problems:

- [Binary tree cameras](./Trees/Binary%20Tree%20Cameras%20(VVIP).java)

## Dynamic Programming

Refer solved problems [here](./Dynamic%20Programming/) 

Some important problems:

- [Reverse knapsack](./Dynamic%20Programming/Reverse%20Knapsack.java)
- [Number of Ways to Build Sturdy Brick Wall](./Dynamic%20Programming/2184.%20Number%20of%20Ways%20to%20Build%20Sturdy%20Brick%20Wall.java)
- [LIS with LIS](./Dynamic%20Programming/LIS%20with%20LIS.java)

## Stacks
Refer solved problems [here](./Stacks%20and%20Queues/)

Some important problems:

- [Next Greater Element I](./Stacks%20and%20Queues/Next%20Greater%20Element%201.java)
- [Next Greater Element II](./Stacks%20and%20Queues/Next%20Greater%20Element%20II.java)

## Queue
[Valid Draw](./Stacks%20and%20Queues/Valid%20Draw.java)

## Inplement data structures
Refer solved problems [here](./Implement%20DS%20using%20other%20DS/)

Some important problems:

- [Insert Delete GetRandom O(1)](./Implement%20DS%20using%20other%20DS/Insert%20Delete%20GetRandom%20O(1).java)

## Math
Refer solved problems [here](./Math/)

Some important problems:

- [Count of ones from 1 to n](./Math/CountNumberOfOnes.java)
- [Basic Calculator II](./Math/Basic%20Calculator%20II.java)

## Rate limiting

Refer these posts

- [Fixed Window Counter and Sliding Window Log](https://medium.com/@devenchan/implementing-rate-limiting-in-java-from-scratch-fixed-window-and-sliding-window-implementation-a6e8d6407d17)
- [Leaky Bucket and Token Bucket](https://medium.com/@devenchan/implementing-rate-limiting-in-java-from-scratch-leaky-bucket-and-tokenn-bucket-implementation-63a944ba93aa)

