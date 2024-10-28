// https://leetcode.com/problems/stone-game-v
// Solution: https://leetcode.com/problems/stone-game-vi/solutions/969574/java-c-python-sort-by-value-sum/

// Same as 1561. Maximum number of coins you can get

// Intuition
// Sort stones by their sum value for Alice and Bob.
// If a stone is super valued for Alice, Alice wants to take it.
// If a stone is super valued for Bob, Alice also wants to take it.
// Because she doesn't want Bob to take it.


// Explanation
// Here is more convinced explanation.
// Assume a stone valued [a,b] for Alice and Bod.
// Alice takes it, worth a for Alice,
// Bob takes it, worth b for Bob,
// we can also consider that it worth -b for Alice.
// The difference will be a+b.
// That's the reason why we need to sort based on a+b.
// And Alice and Bob will take one most valued stone each turn.


// Let me try to explain. The stones must be selected in some kind of order. So assume that the final order is as follows,
// [a1, a2, a3, ...]
// [b1, b2, b3, ...]
// which means Alice picks a1, a3, and so on, and bob picks b2, b4, and so on. Since Alice wants the largest difference between her and Bob, then a1 - b2 >= a2 - b1, i.e., a1 + b1 >= a2 + b2. Therefore, we can sort by the sum of each pair.
class Solution {
    public int stoneGameVI(int[] A, int[] B) {
        int n = A.length;
        int[][] sums = new int[n][];
        for (int i = 0; i < n; i++) {
            sums[i] = new int[] {A[i] + B[i], A[i], B[i]};
        }
        Arrays.sort(sums, (a, b) -> Integer.compare(b[0], a[0]));
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a += sums[i][1];
            } else {
                b += sums[i][2];
            }
        }
        return Integer.compare(a, b);
    }
}