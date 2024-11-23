// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0], high = matrix[matrix.length - 1][matrix[0].length - 1];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            
            int currentRow = matrix.length - 1, currentCol = 0;
            while (currentRow >= 0 && currentCol < matrix[0].length) {
                int value = matrix[currentRow][currentCol];

                if (matrix[currentRow][currentCol] > mid) {
                    currentRow--;
                } else {
                    count += (currentRow + 1);
                    currentCol++;
                }
            }

            if (count >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }
}