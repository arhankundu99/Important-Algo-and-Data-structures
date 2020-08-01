//leetcode prob no 525
//Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

//sol1
class Solution {
    public int findMaxLength(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int maxLength = 0;
        Map<Integer, Integer>map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)count0++;
            else count1++;
            
            if(count1 == count0){
                maxLength = Math.max(maxLength, i+1);
            }
            else{
                if(map.containsKey(count1 - count0)){
                    maxLength = Math.max(maxLength, i - map.get(count1 - count0));
                }
                else map.put(count1 - count0, i);
            }
        }
        return maxLength;
    }
}
// sol2
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int currSum = 0, ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            currSum += (nums[i]*2-1); 
            if(map.containsKey(currSum))
                ans = Math.max(ans, i-map.get(currSum));
            else map.put(currSum, i);
        }
        return ans;
    }
}
