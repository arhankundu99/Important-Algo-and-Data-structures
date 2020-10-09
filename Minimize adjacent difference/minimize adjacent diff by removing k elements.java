// https://csacademy.com/contest/round-34/task/minimize-max-diff/statement/
// Don't place your source in a package
import java.util.*;
import java.lang.*;
import java.io.*;

// Please name your class Main
class Main {
	public static void main (String[] args) throws java.lang.Exception {
	    Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)arr[i] = scan.nextInt();
		
		System.out.println(solve(arr, N, K));
	}
	public static long solve(int[] arr, int N, int K){
	    
	    long low = 0, high = Long.MAX_VALUE;
	    long ans = -1;
	    
	    while(low <= high){
	        long mid = (low + high)/2;
	        
	        int currLength = 1;
	        int currMaxLength = 1;
	        for(int i = 1; i < N; i++){
	            
	            if((long)arr[i] > (long)arr[i-1] + mid){
	                currLength = 1;
	            }
	            else currLength++;
	            currMaxLength = Math.max(currMaxLength, currLength);
	        }
	        if(N - currMaxLength > K){
	            low = mid+1;
	        }
	        else{
	            ans = mid;
	            high = mid-1;
	        }
	    }
	    return ans;
	}
}
