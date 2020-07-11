# Strings

For String Hashing, visit this link: <https://cp-algorithms.com/string/string-hashing.html>

## Important substring search algorithms
1. KMP algorithm
2. Z algorithm
3. Rabin Karp 
4. Boyer Moore
5. Aho-corasick
6. Finite state automation
7. Suffix trees

## Get all starting indices of pattern in a string
```java
int index = word.indexOf(pattern);
while(index >= 0) {
   System.out.println(index);
   index = word.indexOf(pattern, index+1);
}
```
