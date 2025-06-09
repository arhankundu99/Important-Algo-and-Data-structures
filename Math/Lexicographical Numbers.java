// https://leetcode.com/problems/lexicographical-numbers/description/?envType=daily-question&envId=2025-06-09
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> lexicographicalNumbers = new ArrayList<>();
        int currentNumber = 1;

        // Generate numbers from 1 to n
        for (int i = 0; i < n; ++i) {
            lexicographicalNumbers.add(currentNumber);

            // If multiplying the current number by 10 is within the limit, do it
            if (currentNumber * 10 <= n) {
                currentNumber *= 10;
            } else {
                // Adjust the current number by moving up one digit
                while (currentNumber % 10 == 9 || currentNumber >= n) {
                    currentNumber /= 10; // Remove the last digit
                }
                currentNumber += 1; // Increment the number
            }
        }

        return lexicographicalNumbers;
    }

    private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) {
            return;
        }

        result.add(curr);

        for (int i = 0; i <= 9; i++) {
            dfs(curr * 10 + i, n, result);
        }
    }
}
