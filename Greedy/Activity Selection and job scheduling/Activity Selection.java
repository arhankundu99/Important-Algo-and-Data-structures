// https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0){
		    int n = scan.nextInt();
		    pair[] pair = new pair[n];
            
            int[] s = new int[n];
            int[] f = new int[n];
            		    
		    for(int i = 0; i < n; i++)s[i] = scan.nextInt();
		    for(int i = 0; i < n; i++)f[i] = scan.nextInt();
		    for(int i = 0; i < n; i++)
		        pair[i] = new pair(i+1, s[i], f[i]);

		    Arrays.sort(pair, new Comparator<pair>(){
		       public int compare(pair a, pair b){
		           return a.finish-b.finish;
		       } 
		    });
		    int count = 1;
		    System.out.print(pair[0].pos+" ");
		    int idx = 0;
		    for(int i = 1; i < n; i++){
		        if(pair[i].start < pair[idx].finish)continue;
		        count++;
		        idx = i;
		        System.out.print(pair[idx].pos+" ");
		    }
		    System.out.println("");
		}
	}
}
class pair{
    int pos, start, finish;
    pair(int pos,int s, int f){
        this.pos = pos;
        this.start = s;
        this.finish = f;
    }
}
