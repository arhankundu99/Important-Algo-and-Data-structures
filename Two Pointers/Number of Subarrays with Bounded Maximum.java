// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/605/week-3-june-15th-june-21st/3782/
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int l = 0, r = 0, count = 0, idx = -1, max = -1; //idx will contain the leftmost idx in the range [l..r]                                                          //such that max in [idx...r] is less than left
        while(r < nums.length){
            
            //check if nums[r] is greater than bound
            if(nums[r] > right){
                r++;
                l = r;
                //reset max and idx
                max = -1;
                idx = -1;
                continue;
            }
            
            //check the max in the range [l, r];
            max = Math.max(max, nums[r]);
            
            //check if max is less than left
            if(max < left){
                r++;
                continue;
            }
            
            //check if nums[r] is in the bound
            if(nums[r] >= left)idx = r;
            
            //max of [l...r] is in the bound
            
            count += (r - l + 1);
            
            //subtract the subarray count [idx...r] where the max in this range is less than left
            if(nums[r] < left){
                count -= (r - (idx + 1) + 1);
            }
            
            r++;
            
        }
        return count;
    }
}
