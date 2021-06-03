// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/602/week-5-may-29th-may-31st/3761/

class Solution {
    public int maximumGap(int[] nums) {
        radixSort(nums);
        //time complexity = ((n + b) * log(max)/log(b))
        
        int maxGap = 0;
        for(int i = 1; i < nums.length; i++)maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        
        for(int i = 0; i < nums.length; i++)System.out.print(nums[i] + " ");
        System.out.println("");
        
        return maxGap;
    }
    
    public void radixSort(int[] nums) {
        int max = 0;
        for(int num: nums)max = Math.max(max, num);
        
        int exp = 1;
        
        while(max / exp != 0){
            countSort(nums, exp);
            exp *= 10;
        }
    }
    
    public void countSort(int[] nums, int exp){
        int[] count = new int[10];
        
        for(int i = 0; i < nums.length; i++){
            count[(nums[i] / exp) % 10]++;
        }
        
        for(int i = 1; i < 10; i++)count[i] += count[i - 1];
        
        int[] arr = new int[nums.length];
        
        // for(int i = nums.length - 1; i >= 0; i--){
        //    arr[count[(nums[i] / exp) % 10] - 1] = nums[i];
        //    count[(nums[i] / exp) % 10]--;
        // }
        
        // consider this 170, 90, 802, 66
        // in 1st iteration, 90, 170, 802, 66
        // in 2nd iteration  802, 66, 170, 90
        // now in 3rd iteration, 90 will come become 66 which is wrong
        
        //if we go from back, we preserve the order of elements (stable sort)
        for(int i = nums.length - 1; i >= 0; i--){
            arr[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }
       
        for(int i = 0; i < nums.length; i++)nums[i] = arr[i];
    }
}
