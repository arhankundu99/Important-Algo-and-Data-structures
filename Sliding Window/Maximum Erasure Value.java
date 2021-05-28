// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/601/week-4-may-22nd-may-28th/3758/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {        
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0, currSum = 0, max = 0;
        
        while(j < nums.length){
            if(!set.contains(nums[j])){
                currSum += nums[j];
                set.add(nums[j]);
                max = Math.max(max, currSum);
                j++;
            }
            else{
                while(nums[i] != nums[j]){
                    currSum -= nums[i];
                    set.remove(nums[i]);
                    i++;
                }
                currSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
           // System.out.println(i + " " + j);
        }
        return max;
    }
}
