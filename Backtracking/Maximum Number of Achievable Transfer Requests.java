// https://leetcode.com/contest/weekly-contest-208/problems/maximum-number-of-achievable-transfer-requests/
class Solution {
    public int maximumRequests(int n, int[][] requests) {
        int count = dfs(requests, 0, new int[n]);
        
        if(count < 0)return 0;
        return count;
    }
    public int dfs(int[][] requests, int idx, int[] count){
        if(idx == requests.length){
            for(int i = 0; i < count.length; i++){
                if(count[i] != 0){
                    return Integer.MIN_VALUE;
                }
            }
            return 0;
        }
        
        int u = requests[idx][0];
        int v = requests[idx][1];
        
        count[u]--;
        count[v]++;
        
        //choose this
        int ans = 1 + dfs(requests, idx+1, count);
        
        //backtrack
        count[u]++;
        count[v]--;
        
        //do not choose this
        ans = Math.max(ans, dfs(requests, idx+1, count));
        
        return ans;
    }
}
