// https://leetcode.com/problems/find-the-duplicate-number/
// Inspired by JOMA :)
class Solution {
    public int findDuplicate(int[] nums) {
        // arr = [1, 1, 4, 2, 2];
 
        int tortoise = nums[0];
        int hare = nums[0];
        
        while(true){
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
            
            if(tortoise == hare)break;
        }

        tortoise = nums[0];
        
        while(tortoise != hare){
            tortoise = nums[tortoise];
            hare = nums[hare];
        }
        return tortoise;
    }
}
//for explaination of the floyd cycle algorithm read this post: https://qr.ae/pG2MEJ
//What happens when hare moves k times faster than the tortoise (k > 2) ?
