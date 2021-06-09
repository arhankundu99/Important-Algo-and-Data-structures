// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3773/
class Solution {
    public int maxResult(int[] nums, int k) {
        //dp[i] = max(dp[i - k],....dp[i - 1]) + nums[i];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        System.out.println(nums.length);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){return b - a;}
        });
        maxHeap.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++){
            int currMax = maxHeap.peek(); //currMax will store the current maximum of the window
            
            dp[i] = currMax + nums[i];
            
            maxHeap.add(dp[i]);
            
            //if window size is greater than k, remove dp[i - k];
            if(maxHeap.size() > k)maxHeap.remove(dp[i - k]);
            
        }
        //print(dp);
        return dp[nums.length - 1];
    }
    public void print(int[] arr){
        for(int i = 0; i < arr.length; i++)System.out.print(arr[i] + " ");
        System.out.println("");
    }
}
