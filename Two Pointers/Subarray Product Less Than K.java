//Your are given an array of positive integers nums.
//Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
// 0 < nums.length <= 50000.
// 0 < nums[i] < 1000.
// 0 <= k < 10^6.

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0||k == 1)return 0;
        int idx1 = 0,idx2 = 0,currP=1,count=0;
        while(idx2 < nums.length)
        {
            currP *= nums[idx2];
            if(currP >= k) while(idx1 < nums.length && currP >= k)currP /= nums[idx1++];
            count += idx2-idx1+1;
            idx2++;
        }
        return count;
    }
}

// Idea: Sliding Window Approach
// Time Complexity O(n) Space Complexity O(1)
