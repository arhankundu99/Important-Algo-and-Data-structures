/*package whatever //do not write package name here */
// Follow up: What if we could add any 2 elements from the array and merge them? what will be the minimum cost?....Yes, greedy approach will work:) 
// Add two minimum elements every time and add them in priority queue 
import java.util.*;

class GFG {
    static int[][]dp;
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		dp = new int[n][n];
		for(int i = 0; i < n; i++)Arrays.fill(dp[i], -1);
		int[] a = new int[n];
		for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		
		int[] prefixSum = new int[n];
		for(int i = 0; i < n; i++){
		    if(i == 0)prefixSum[i] = a[i];
		    else prefixSum[i] = a[i] + prefixSum[i-1];
		}
		
		System.out.println(solve(a, prefixSum, 0, n-1));
	}
	public static int solve(int[]a, int[] prefixSum, int low, int high){
	    if(low == high - 2){
	        return Math.min(2*(a[low] + a[low+1]) + a[high], 2*(a[low+1] + a[high])+a[low]);
	    }
	    if(low == high - 1){
	        return a[low] + a[high];
	    }
	    if(dp[low][high] != -1)return dp[low][high];
	    int ans = Integer.MAX_VALUE;
	    int sum = low == 0? prefixSum[high]: prefixSum[high] - prefixSum[low-1];
	    for(int i = low+1; i <= high-2; i++){
	        ans = Math.min(ans, sum + solve(a, prefixSum, low, i) + solve(a, prefixSum, i+1, high));
	    }
	    dp[low][high] = ans;
	    return ans;
	}
}

//GFG Solution: Bottom up approch
static int mergeTwoNumbers(int []numbers) 
{ 
    int len, i, j, k; 
    int n = numbers.length; 
    if (numbers.length == 0) 
    { 
        return 0; 
    } 
  
    int []prefixSum = new int[n + 1]; 

    for (i = 1; i <= n; i++)  
    { 
        prefixSum[i] = prefixSum[i - 1] + 
                         numbers[i - 1]; 
    } 
   
    int [][]dp = new int[n + 1][n + 1]; 
  
    for (len = 2; len <= n; len++)  
    { 
  
        for (i = 1; i <= n - len + 1; i++) 
        { 
            j = i + len - 1; 

            int sum = prefixSum[j] -  
                      prefixSum[i - 1]; 
  
            dp[i][j] = Integer.MAX_VALUE; 

            for (k = i; k < j; k++)  
            { 
                dp[i][j] = Math.min(dp[i][j],  
                                    dp[i][k] + 
                                    dp[k + 1][j] +  
                                    sum); 
            } 
        } 
    } 
    return dp[1][n]; 
} 
