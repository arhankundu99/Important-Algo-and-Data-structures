//https://leetcode.com/problems/total-hamming-distance/submissions/1
class Solution {
    public int totalHammingDistance(int[] nums) {
        int count = 0;
        for(int i = 0; i < 32; i++){
            int zeroes = 0;
            for(int num: nums){
                if(((num >> i) & 1) == 0)zeroes++;
            } 
            count += zeroes * (nums.length - zeroes);
        }
        return count;
    }
}
