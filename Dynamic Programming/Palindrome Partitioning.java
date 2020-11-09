//https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1
//return minimum number of cuts to make a string palindrome
class Solution{
    static int palindromicPartition(String str)
    {
        if(str.length() <= 1)return 0;
      
        boolean[][] isPalindrome = new boolean[str.length()][str.length()];
        for(int i = 0; i < str.length(); i++)isPalindrome[i][i] = true;
        for(int i = 0; i < str.length() - 1; i++)if(str.charAt(i) == str.charAt(i+1))isPalindrome[i][i+1] = true;
        
        for(int i = str.length() - 3; i >= 0; i--){
            for(int j = i + 2; j < str.length(); j++){
                if(str.charAt(i) == str.charAt(j))isPalindrome[i][j] = isPalindrome[i+1][j-1];
            }
        }
        int[][] dp = new int[str.length()][str.length()];
        for(int i = 0; i < str.length(); i++)Arrays.fill(dp[i], -1);
        return f(str, 0, str.length() - 1, isPalindrome, dp);
    }
    static int f(String s, int a, int b, boolean[][] isPalindrome, int[][] dp){
        if(a >= b)return 0;
        
        if(dp[a][b] != -1)return dp[a][b];
        if(isPalindrome[a][b])return 0;
        int minCuts = Integer.MAX_VALUE;
        for(int i = a; i <= b; i++){
            if(isPalindrome[a][i]){
                minCuts = Math.min(minCuts, 1 + f(s, i + 1, b, isPalindrome, dp));
            }
        }
        return dp[a][b] = minCuts;
    }
}

static int palindromicPartition(String a)
{
    int[] cut = new int[a.length()]; 
    boolean[][] palindrome = new boolean[a.length()][a.length()]; 
  
    for (int i = 0; i < a.length(); i++) { 
        int minCut = i; 
        for (int j = 0; j <= i; j++) { 
            if (a.charAt(i) == a.charAt(j) && (i - j < 2 || palindrome[j + 1][i - 1])) { 
                palindrome[j][i] = true; 
                minCut = Math.min(minCut, j == 0 ? 0 : (cut[j - 1] + 1)); 
            } 
        } 
        cut[i] = minCut; 
    } 
  
    return cut[a.length() - 1]; 
}
