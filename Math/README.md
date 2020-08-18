# Catalan Number
Read about catalan numbers from here: <https://en.wikipedia.org/wiki/Catalan_number#:~:text=In%20combinatorial%20mathematics%2C%20the%20Catalan,Catalan%20(1814%E2%80%931894).>

## Important points about catalan number
1. A convex polygon with n + 2 sides can be cut into triangles by connecting vertices with non-crossing line segments (a form of polygon triangulation). The number of triangles formed is n and the number of different ways that this can be achieved is Cn.
2. Cn is the number of full binary trees with n + 1 leaves
3. Cn is the number of Dyck words of length 2n. A Dyck word is a string consisting of n X's and n Y's such that no initial segment of the string has more Y's than X's.
4. Re-interpreting the symbol X as an open parenthesis and Y as a close parenthesis, Cn counts the number of expressions containing n pairs of parentheses which are correctly matched.
5. Cn is the number of different ways n + 1 factors can be completely parenthesized (or the number of ways of associating n applications of a binary operator).
6. Cn is the number of unique BST which have n nodes from 1 to n.
7. Cn is the number of non-isomorphic ordered trees with n + 1 vertices.


<https://www.quora.com/How-many-Binary-heaps-can-be-made-from-N-distinct-elements> (VIP) <br />

# Count number of ways to partition a set into k subsets

```S(n, k) = k*S(n-1, k) + S(n-1, k-1)```
**S(n, k) is called Stirling numbers of 2nd kind**

Explaination: 
```first term k*S(n-1, k)``` denotes divide n-1 numbers in k subsets and add n in any one of the subset
```second term S(n-1, k-1)``` denotes putting the nth element in a seperate partiion

# Bell numbers: Count the number of ways to partition a set


```
   B[0][0] = 1
   B[i][j] = B[i-1][i-1] if j = 0
           = B[i-1][j-1] + B[i][j-1]
```
The number of ways is given by ```B[N][0]```

# Find Nth square free number
A number is square free if it is not divisible by any perfect square other than 1
<https://www.geeksforgeeks.org/nth-square-free-number/> <br/>
