  
//Problem no 287
//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
//prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[Math.abs(nums[i])]<0)return Math.abs(nums[i]);
            nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
        }
        return -1;
    }
}

// Getting Idea
// The easiest solution would be to use a hashmap to detect the duplicate number
// But notice that the array contains integers which lies between 1 to n
// So instead of using map, use the values of array as hash keys instead
// Time Complexity- O(n)  Space Complexity- O(1)
