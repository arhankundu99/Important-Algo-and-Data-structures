Difficulty level: Easy Medium
Idea: Greedy
/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
  static int shiftCount = 0;
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-->0)
	    {
	        shiftCount = 0;
	        int[]index = new int[2];
	        Arrays.fill(index, -1);
	        List<pair>list = new ArrayList<>();
	        
	        int n = scan.nextInt();
	        int k = scan.nextInt();
	        int []p = new int[n];
	        Map<Integer, Integer>map = new HashMap<>();
	        
	        for(int i=0;i<n;i++)
	        {
	            p[i] = scan.nextInt();
	            map.put(p[i], i);
	        }
	        
	        for(int i=0;i<n-1;i++)
	        {
	            int find = i+1;
	            if(p[i] == i+1)continue;
	            
	            int chosenIdx1 = i;
	            int chosenIdx2 = -1, chosenIdx3 = -1;
	            
	            if(p[i]-1 != map.get(find))
	            {
	                chosenIdx2 = p[i]-1;
	                chosenIdx3 = map.get(find);
	                list.add(new pair(chosenIdx1+1, chosenIdx2+1, chosenIdx3+1));
	                swap(p, chosenIdx1, chosenIdx2, chosenIdx3, map);
	            }
	            else
	            {
	                if(index[0] == -1)
	                {
	                    index[0] = i;
	                    index[1] = map.get(find);
	                }
	                else
	                {
	                    if(index[1] == i)continue;
	                    int fIdx = i;
	                    int sIdx = map.get(find);
	                        
	                    chosenIdx1 = index[0];
	                    chosenIdx2 = sIdx;
	                    chosenIdx3 = index[1];
	                        
	                    list.add(new pair(chosenIdx1+1, chosenIdx2+1, chosenIdx3+1));
	                    swap(p, chosenIdx1, chosenIdx2, chosenIdx3, map);
	                        
	                    chosenIdx1 = fIdx;
	                    chosenIdx2 = sIdx;
	                    chosenIdx3 = index[1];
	                        
	                    list.add(new pair(chosenIdx1+1, chosenIdx2+1, chosenIdx3+1));
	                    swap(p, chosenIdx1, chosenIdx2, chosenIdx3, map);
	                        
	                    index[0] = -1;
	                    index[1] = -1;
	                }
	            }
	        }
	        boolean flag = true;
	        for(int i=0;i<n-1;i++)
	        {
	            if(p[i] > p[i+1])
	            {
	                flag = false;
	                break;
	            }
	        }
	        if(!flag || shiftCount > k)
	        {
	            System.out.println(-1);
	            continue;
	        }
	        if(flag)
	        {
	            System.out.println(list.size());
	            for(int i=0;i<list.size();i++)
	                System.out.println(list.get(i).first+" "+list.get(i).second+" "+list.get(i).third);
	        }
	    }
	}
	public static void swap(int[] p, int idx1, int idx2, int idx3, Map<Integer,Integer>map)
	{
	    int temp1 = p[idx1];
	    int temp2 = p[idx2];
	    int temp3 = p[idx3];
	    
	    p[idx1] = temp3;
	    p[idx2] = temp1;
	    p[idx3] = temp2;
	    
	    map.put(p[idx1], idx1);
	    map.put(p[idx2], idx2);
	    map.put(p[idx3], idx3);
	    
	    shiftCount++;
	}
}
class pair
{
    int first, second, third;
    pair(int f, int s, int t)
    {
        this.first = f;
        this.second = s;
        this.third = t;
    }
}
