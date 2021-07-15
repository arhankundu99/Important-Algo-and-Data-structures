// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/610/week-3-july-15th-july-21st/3815/
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int k = nums.length - 1; k >= 2; k--){
            int i = 0, j = k - 1;
            
            while(i < j){
                if(nums[i] == 0){
                    i++;
                    continue;
                }
                if(nums[i] + nums[j] > nums[k]){
                    count += j - i;
                    j--;
                }
                else i++;
            }
        }
        return count;
    }
}

