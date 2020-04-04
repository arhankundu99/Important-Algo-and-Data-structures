//There is one meeting room in a firm. 
//There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

//What is the maximum number of meetings that can be accommodated in the meeting room?

import java.util.*;
import java.lang.*;

class Solution {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    int n=scan.nextInt();
		    Meeting[] meetings = new Meeting[n];
		    
		    int[]s=new int[n];
		    int[]f=new int[n];
		    
		    for(int i=0;i<n;i++)s[i] = scan.nextInt();
		    for(int i=0;i<n;i++)f[i] = scan.nextInt();
		    
		    for(int i=0;i<n;i++)meetings[i] = new Meeting(s[i], f[i], i+1);
		    
		    Arrays.sort(meetings, new Comparator<Meeting>(){
		        public int compare(Meeting a, Meeting b)
		        {
		            return a.end-b.end;
		        }
		    });
		    
		    int prevFinishTime=0;
		    for(int i=0;i<n;i++)
		    {
		        if(meetings[i].start>=prevFinishTime)
		        {
		            System.out.print(meetings[i].pos+" ");
		            prevFinishTime = meetings[i].end;
		        }
		    }
		    System.out.println("");
		}
	}
}
class Meeting
{
    int start,end,pos;
    Meeting(int s,int e,int p)
    {
        this.start = s;
        this.end = e;
        this.pos = p;
    }
}
