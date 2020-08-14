Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

// Approach 1: Backtracking (Time limit Error)
// Time Complexity: O(2^N) Worst Case, O(N) Best Case, Average: O(2^N)
// Space Complexity: O(N)
class Solution {
    List<Integer>ans;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        ArrayList<Integer>list = new ArrayList<>();
        solve(nums, list, 0);
        return ans;
    }
    public void solve(int[] nums, ArrayList<Integer>list, int idx)
    {
        if(idx == nums.length)
        {
            if(ans.size() < list.size())ans = new ArrayList(list);
            return;
        }
        if(list.size() == 0 || nums[idx] % list.get(list.size()-1) == 0)
        {
            list.add(nums[idx]);
            solve(nums, list, idx+1);
            list.remove(list.size()-1);
            solve(nums, list, idx+1);
        }
        else solve(nums, list, idx+1);
        
    }
}

// Approach 2: Using DP
// Time Complexity: O(N*N)
// Space Complexity: O(N)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0)return ans;
        int[][]dp = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++)
        {
            dp[i][0] = 1;
            dp[i][1] = -1;
        }
        int maxLength = 1, lastIdx = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] % nums[j] == 0 && dp[i][0] <= dp[j][0])
                {
                    dp[i][0] = 1 + dp[j][0];
                    dp[i][1] = j;
                }
            }
            if(maxLength < dp[i][0])
            {
                maxLength = dp[i][0];
                lastIdx = i;
            }
        }
        ans.add(nums[lastIdx]);
        
        while(dp[lastIdx][1] != -1)
        {
            lastIdx = dp[lastIdx][1];
            ans.add(nums[lastIdx]);
        }
        Collections.reverse(ans);
        return ans;
    }
}
