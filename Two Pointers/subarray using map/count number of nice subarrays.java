// https://leetcode.com/problems/count-number-of-nice-subarrays/
// Problem no 1248
// Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.
// Return the number of nice sub-arrays.

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer>map=new HashMap<>();
        map.put(0,1);
        int count=0,ret=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2!=0)count++;
            if(map.containsKey(count))map.put(count,map.get(count)+1);
            else map.put(count,1);
            if(map.containsKey(count-k))ret+=map.get(count-k);
        }
        return ret;
    }
}

//Idea
// for a subarray nums[0...x] where x lies between 1 to nums.length, if the number of odd numbers are y,
// we just have to find out number of subarrays nums[0...z] where z lies between 1 to x which have y-k odd numbers
