//https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/563/week-5-october-29th-october-31st/3513/
// O(N^2) time O(N^2) space
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int count = 0, n = nums.length, maxLength = 1;
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                    maxLength = Math.max(maxLength, lis[i]);
                }
            }
        }
        
        int[][] dp = new int[n][n+1];
        //dp[i][j] denotes the number of increasing subsequences with ith idx and jth length
        for(int i = 0; i < n; i++)dp[i][1] = 1;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i][lis[j] + 1] += dp[j][lis[j]];
                }
            }
        }
        for(int i = 0; i < n; i++){
            count += dp[i][maxLength];
        }
        
        return count;
    }
}
// O(N^2) time O(N) space
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, maxLength = 1;
        int[] lis = new int[n];
        int[] count = new int[n]; //count[i] denotes the number of increasing subsequences of maxLength
        Arrays.fill(lis, 1);
        Arrays.fill(count, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(lis[i] < lis[j] + 1){
                        count[i] = count[j];
                        lis[i] = lis[j] + 1;
                    }
                    else if(lis[i] == lis[j] + 1)count[i] += count[j];
                    maxLength = Math.max(maxLength, lis[i]);
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(lis[i] == maxLength)ans += count[i];
        }
        
        return ans;
    }
}
