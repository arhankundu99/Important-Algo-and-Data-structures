leetcode problem 403
/*
A frog is crossing a river. The river is divided into x units and at each unit there may or may not exist a stone. 
The frog can jump on a stone, but it must not jump into the water.

Given a list of stones' positions (in units) in sorted ascending order, 
determine if the frog is able to cross the river by landing on the last stone. 
Initially, the frog is on the first stone and assume the first jump must be 1 unit.

If the frog's last jump was k units, then its next jump must be either k - 1, k, or k + 1 units. 
Note that the frog can only jump in the forward direction.
*/
class Solution {
    public boolean canCross(int[] stones) {
        int N = stones.length;
        boolean[][] dp = new boolean[N][N + 1];
        dp[0][1] = true;
        
        for(int i = 1; i < N; ++i){
            for(int j = 0; j < i; ++j){
                int diff = stones[i] - stones[j];
                if(diff < 0 || diff > N || !dp[j][diff]) continue;
                dp[i][diff] = true;
                if(diff - 1 >= 0) dp[i][diff - 1] = true;
                if(diff + 1 <= N) dp[i][diff + 1] = true;
                if(i == N - 1) return true;
            }
        }

        return false;
    }
}

 class Solution {
    public boolean canCross(int[] stones) {
        Set<Integer>[] set = new HashSet[stones.length];
        
        for(int i = 0; i < stones.length; i++)set[i] = new HashSet<>();
        
        set[0].add(0);
        
        for(int i = 1; i < stones.length; i++){
            for(int j = 0; j < i; j++){
                int dist = stones[i] - stones[j];
                
                if(set[j].contains(dist-1) || set[j].contains(dist) || set[j].contains(dist+1))
                    set[i].add(dist);
            }
        }
        return set[stones.length-1].size() == 0?false: true;
    }
}


class Solution {
    boolean[]vis;
    int[][]dp;
    Map<Integer, Integer>map = new HashMap<>();
    public boolean canCross(int[] stones) {

        vis = new boolean[stones.length];
        dp = new int[stones.length][stones.length];
        
        for(int i=0;i<dp.length;i++)Arrays.fill(dp[i], -1);
        
        for(int i=0;i<stones.length;i++)map.put(stones[i],i);
        return canCross(0, 0, stones);
    }
    public boolean canCross(int prev,int idx, int[]stones)
    {
        if(idx==stones.length-1)return true;
        if(dp[prev][idx]!=-1)return dp[prev][idx]==1?true:false;
        if(vis[idx])return false;
        vis[idx] = true;
        
        if(map.containsKey(stones[idx]+prev-1) && canCross(prev-1,map.get(stones[idx]+prev-1),stones))
        {
            dp[prev][idx]=1;
            return true;
        }
        if(map.containsKey(stones[idx]+prev) && canCross(prev,map.get(stones[idx]+prev),stones))
        {
            dp[prev][idx]=1;
            return true;
        }
        if(map.containsKey(stones[idx]+prev+1) && canCross(prev+1,map.get(stones[idx]+prev+1),stones))
        {
            dp[prev][idx]=1;
            return true;
        }
        
        vis[idx]=false;
        
        dp[prev][idx]=0;
        return false;
    }
}
