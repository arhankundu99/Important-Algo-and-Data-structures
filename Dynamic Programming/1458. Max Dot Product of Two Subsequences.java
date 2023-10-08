class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        for(int i = 0; i < nums1.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return maxDotProduct(nums1, nums2, 0, 0, dp);
    }

    private int maxDotProduct(int[] nums1, int[] nums2, int idx1, int idx2, int[][] dp){
        if(idx1 == nums1.length || idx2 == nums2.length){
            return Integer.MIN_VALUE;
        }

        if(dp[idx1][idx2] != -1){
            return dp[idx1][idx2];
        }

        // choose idx1 and idx2
        int dotProduct = maxDotProduct(nums1, nums2, idx1 + 1, idx2 + 1, dp);
        if(dotProduct < 0){
            dotProduct = 0;
        }
        dotProduct += nums1[idx1] * nums2[idx2];

        dotProduct = Math.max(dotProduct, maxDotProduct(nums1, nums2, idx1, idx2 + 1, dp));
        dotProduct = Math.max(dotProduct, maxDotProduct(nums1, nums2, idx1 + 1, idx2, dp));

        return dp[idx1][idx2] = dotProduct;

    }
}
