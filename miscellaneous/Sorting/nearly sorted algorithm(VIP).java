/*package whatever //do not write package name here */
// https://practice.geeksforgeeks.org/problems/nearly-sorted-algorithm/0

import java.util.*;
import java.lang.*;
import java.io.*;

// total time complexity: O(nk)
class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    
		    for(int i = 1; i < n; i++){
		        int key = a[i];
		        int j = i-1;
		        
            // this loop will run atmost k times
		        while(j >= 0 && a[j] > key){
		            a[j+1] = a[j];
		            j--;
		        }
		        a[j+1] = key;
		    }
		    for(int i = 0; i < n; i++)System.out.print(a[i] + " ");
		    System.out.println("");
		}
	}
}


// using priority queue (min heap)
/*package whatever //do not write package name here */
// time complexity O(nlogk)
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    
		    int[]a = new int[n];
		    for(int i = 0; i < n; i++)a[i] = scan.nextInt();
		    
		    PriorityQueue<Integer>queue = new PriorityQueue<>();
		    
		    for(int i = 0; i < Math.min(n, k+1); i++)queue.add(a[i]);
		    
		    int idx = 0;
		    for(int i = k+1; i < n; i++){
		        a[idx++] = queue.poll();
		        queue.add(a[i]);
		    }
		    while(queue.size() != 0){
		        a[idx++] = queue.poll();
		    }
		    for(int i = 0; i < n; i++)System.out.print(a[i]+" ");
		    System.out.println("");
		}
	}
}
