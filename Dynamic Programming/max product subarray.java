// https://leetcode.com/problems/maximum-product-subarray/
class Solution {
    public int maxProduct(int[] a) {
        int currMax = 1, currMin = 1;
        int ans = Integer.MIN_VALUE;
        
        for(int i = 0; i < a.length; i++){
            int tempMax = Math.max(a[i], a[i]*currMax);
            tempMax = Math.max(tempMax, a[i]*currMin);
            
            int tempMin = Math.min(a[i], a[i]*currMin);
            tempMin = Math.min(tempMin, a[i]*currMax);
            
            currMax = tempMax;
            currMin = tempMin;
            
            ans = Math.max(ans, currMax);
        }
        return ans;
    }
}
