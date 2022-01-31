// https://leetcode.com/problems/rotate-array/submissions/
class Solution {

    public void rotate(int[] nums, int k) {

        

        //let nums = {a1, a2, a3......., an}

        //rotating the array k times is equivalent to rotating the array k % nums.length times

        

        //after rotating the array nums k % nums.length times

        //nums = {a(n - k + 1)....an, a1, a2.....a(n - k)}

        

        //this can be achieved in 3 steps

        //reverse(a, 0, n - 1) => nums = {a(n), a(n - 1), ..........a1}

        //reverse(a, 0, k - 1) => nums = {a(n - k + 1), a(n - k + 2)......a(n), a(n - k).....a1}

        //reverse(a, k, n - 1) => nums = {a(n - k + 1), a(n - k + 2)......a(n), a1, a2,.....a(n - k)}

        

        reverse(nums, 0, nums.length - 1);

        reverse(nums, 0, k % nums.length - 1);

        reverse(nums, k % nums.length, nums.length - 1);

    }

    

    public void reverse(int[] nums, int low, int high){

        while(low < high){

            nums[low] = nums[low] ^ nums[high];

            nums[high] = nums[low] ^ nums[high];

            nums[low] = nums[low] ^ nums[high];

            

            low++;

            high--;

        }

    }

}
