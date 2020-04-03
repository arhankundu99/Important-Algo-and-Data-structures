// Prob no 1340
/*
Given an array of integers arr and an integer d. In one step you can jump from index i to index:

i + x where: i + x < arr.length and 0 < x <= d.
i - x where: i - x >= 0 and 0 < x <= d.
In addition, you can only jump from index i to index j if arr[i] > arr[j] and arr[i] > arr[k] for all indices k between i and j (More formally min(i, j) < k < max(i, j)).

You can choose any index of the array and start jumping. Return the maximum number of indices you can visit.
*/

class Solution {
    int[]dp;
    public int maxJumps(int[] arr, int d) {
        int ret=0;
        dp=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            int curr = 0;
            curr = 1+Math.max(dfs(arr,i,d),curr);
            ret = Math.max(ret, curr);
        }
        return ret;
    }
    public int dfs(int[]arr, int idx, int d)
    {
        int ret=0;
        if(dp[idx]!=0)return dp[idx];
        for(int i=idx-1;i>=0&&idx-i<=d;i--)
        {
            if(arr[i]>=arr[idx])break;
            int curr = 0;
            curr = 1+Math.max(dfs(arr,i,d),curr);
            ret = Math.max(ret, curr);
        }
        for(int i=idx+1;i<arr.length&&i-idx<=d;i++)
        {
            if(arr[i]>=arr[idx])break;
            int curr = 0;
            curr = 1+Math.max(dfs(arr,i,d),curr);
            ret = Math.max(ret, curr);
        }
        dp[idx]=ret;
        return ret;
    }
}
