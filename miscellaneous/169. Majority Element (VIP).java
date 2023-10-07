// https://leetcode.com/problems/majority-element/

class Solution {
    public int majorityElement(int[] nums) {
        // first solution => hashmap => O(n) time and space
        // second solution => Sort => O(nlogn) time and O(1) space
        // third solution => Moore-Voting algorithm

        int candidate = nums[0];
        int count = 1;

        for(int i = 1; i < nums.length; i++){
            if(candidate != nums[i]){
                count--;
            }
            else{
                count++;
            }

            if(count == 0){
                candidate = nums[i];
                count = 1;
            }
        }

        return candidate;
    }
}