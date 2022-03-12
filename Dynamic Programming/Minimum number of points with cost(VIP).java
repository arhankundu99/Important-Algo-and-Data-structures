
//https://leetcode.com/problems/maximum-number-of-points-with-cost/
//1. Brute Force Solution

class Solution {
    public long maxPoints(int[][] points) {
        return getMaxPoints(points, 0, -1);
    }
    
    // Space complexity: O(m) where m is number of rows (stack space due to recursion), 
    // Time complexity: O(n ^ m) (exponential)
    public long getMaxPoints(int[][] points, int currRow, int prevCol){
        //base case
        if(currRow == points.length)return 0;
        
        long maxPoints = 0;
        for(int i = 0; i < points[currRow].length; i++){
            
            if(prevCol != -1)
                maxPoints = Math.max(maxPoints, 
                                     points[currRow][i] - Math.abs(i - prevCol) +  
                                     getMaxPoints(points, currRow + 1, i));
            else maxPoints = Math.max(maxPoints, points[currRow][i] + getMaxPoints(points, currRow + 1, i));
        }
        
        return maxPoints;
    }
}
//2. Top Down Memoization Solution

class Solution {
    
    long[][] dp;
    public long maxPoints(int[][] points) {
        dp = new long[points.length][points[0].length];
        
        for(int i = 0; i < points.length; i++)
            Arrays.fill(dp[i], -1);
        
        return getMaxPoints(points, 0, -1);
    }
    
    // Space complexity: O(m * n) where m is number of rows and n is number of columns
    // Time complexity: O(m * n * n)
    public long getMaxPoints(int[][] points, int currRow, int prevCol){
        //base case
        if(currRow == points.length)return 0;
        
        if(prevCol != -1 && dp[currRow][prevCol] != -1)return dp[currRow][prevCol];
        
        long maxPoints = 0;
        for(int i = 0; i < points[currRow].length; i++){
            
            if(prevCol != -1)
                maxPoints = Math.max(maxPoints, 
                                     points[currRow][i] - Math.abs(i - prevCol) +  
                                     getMaxPoints(points, currRow + 1, i));
            else maxPoints = Math.max(maxPoints, points[currRow][i] + getMaxPoints(points, currRow + 1, i));
        }
        
        if(prevCol != -1)dp[currRow][prevCol] = maxPoints;
        return maxPoints;
    }
}
//3. Bottom Up DP Solution

class Solution {

    //Space Complexity: O(m * n)
    //Time complexity: O(m * n * n)
    public long maxPoints(int[][] points) {
        long maxPoints = 0;
        long[][] dp = new long[points.length][points[0].length];

        for(int c = 0; c < points[0].length; c++)dp[0][c] = points[0][c];
        
        for(int i = 1; i < points.length; i++){
            
            for(int j = 0; j < points[0].length; j++){
                
                for(int k = 0; k < points[0].length; k++){
                    
                    dp[i][j] = Math.max(dp[i][j], points[i][j] + dp[i - 1][k] - Math.abs(j - k));
                    maxPoints = Math.max(maxPoints, dp[i][j]);
                }
            }
        }
        
        return maxPoints;
    }
}
//4. Optimized Bottom Up DP Solution

class Solution {

    //Space Complexity: O(m * n)
    //Time complexity: O(m * n)
    public long maxPoints(int[][] points) {
        long maxPoints = 0;
        long[][] dp = new long[points.length][points[0].length];

        for(int c = 0; c < points[0].length; c++){
            dp[0][c] = points[0][c];
            maxPoints = Math.max(maxPoints, dp[0][c]);
        }
        
        for(int i = 1; i < points.length; i++){
            
            long[] prefix = new long[points[0].length];
            long[] suffix = new long[points[0].length];
            
            prefix[0] = dp[i - 1][0] + 0;
            for(int j = 1; j < points[0].length; j++)
                prefix[j] = Math.max(prefix[j - 1], dp[i - 1][j] + j);
            
            suffix[points[0].length - 1] = dp[i - 1][points[0].length - 1] - (points[0].length - 1);
            for(int j = points[0].length - 2; j >= 0; j--)
                suffix[j] = Math.max(suffix[j + 1], dp[i - 1][j] - j);
                
            for(int j = 0; j < points[0].length; j++){
                dp[i][j] = Math.max(dp[i][j], points[i][j] + Math.max(prefix[j] - j, suffix[j] + j));
                maxPoints = Math.max(maxPoints, dp[i][j]);
            }
        }
        
        return maxPoints;
    }
}
