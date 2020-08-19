// https://leetcode.com/problems/number-of-music-playlists/

class Solution {
    public int numMusicPlaylists(int N, int L, int K) {
        int M = 1000000007;
        
        long[][] dp = new long[L+1][N+1];
        // dp[i][j] represents the number of playlists of length i and j unique songs
        
        dp[0][0] = 1;
        
        for(int i = 1; i <= L; i++){
            for(int j = 1; j <= N; j++){
                // playing an unique song for the first time
                dp[i][j] += (dp[i-1][j-1])*(N-(j-1));
                
                // playing a repreated song
                dp[i][j] += dp[i-1][j] * Math.max(j-K, 0);
                
                dp[i][j] %= M;
            }
        }
        return (int)dp[L][N];
    }
}
