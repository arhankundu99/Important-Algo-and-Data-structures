// Problem 135 
// https://leetcode.com/problems/candy/
class Solution {
    public int candy(int[] ratings) {
        int[] L2R = new int[ratings.length];
        int[] R2L = new int[ratings.length];

        Arrays.fill(L2R, 1);
        Arrays.fill(R2L, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                L2R[i] = L2R[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                R2L[i] = R2L[i + 1] + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
            count += Math.max(L2R[i], R2L[i]);
        }
        return count;
    }
}
