// Codechef
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t=scan.nextInt();
		while(t-->0)
		{
		    int n = scan.nextInt();
		    int k = scan.nextInt();
		    
		    ArrayList<Integer>[] adjList = new ArrayList[n];
		    
		    for(int i=0;i<n;i++)adjList[i] = new ArrayList<>();
		    
		    for(int i=0;i<n;i++)
		    {
		        String s = scan.next();
		        for(int j=0;j<n;j++)
		            if(s.charAt(j)=='1'&&Math.abs(i-j)<=k)
		                adjList[i].add(j);
		    }
		    
		    int[]dist = new int[n];
		    for(int i=1;i<n;i++)dist[i]=-1;
		    boolean[]isVisited = new boolean[n];
		    
		    bfs(0,n-1,dist,isVisited,adjList);
		    System.out.println(dist[n-1]);
		}
	}
	public static void bfs(int currPos, int dest, int[]dist,boolean[] isVisited,ArrayList<Integer>[]adjList)
	{
	    if(currPos==dest)return;
	    Queue<Integer>queue = new LinkedList<>();
	    queue.add(currPos);
	    isVisited[currPos] = true;
	    while(queue.size()!=0)
	    {
	        int u= queue.poll();
	        for(int i=0;i<adjList[u].size();i++)
	        {
	            if(isVisited[adjList[u].get(i)])continue;
	            isVisited[adjList[u].get(i)]=true;
	            dist[adjList[u].get(i)] = dist[u]+1;
	            queue.add(adjList[u].get(i));
	        }
	    }
	    
	}
}
