Problem link: https://www.codechef.com/LRNDSA08/problems/ACM14KG3
Floyd Warshall algorithm is used

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while(t-->0)
		{
		    String a = scan.next();
		    String b = scan.next();
		    
		    int m = scan.nextInt();
		    
		    boolean[][] isConnected = new boolean[26][26];
		    
		    while(m-->0)
		    {
		        String connection = scan.next();
		        isConnected[connection.charAt(0)-97][connection.charAt(connection.length()-1)-97] = true;
		    }
		    for(int k = 0; k < 26; k++)
		    {
		        for(int i = 0; i < 26; i++)
		        {
		            for(int j = 0; j < 26; j++)
		            {
		                if(isConnected[i][k] && isConnected[k][j])
		                    isConnected[i][j] = true;
		            }
		        }
		    }
		    if(a.length() != b.length())
		    {
		        System.out.println("NO");
		        continue;
		    }
		    boolean flag = false;
		    for(int i = 0; i < a.length(); i++)
		    {
		        if(a.charAt(i) != b.charAt(i) && !isConnected[a.charAt(i)-97][b.charAt(i)-97])
		        {
		            System.out.println("NO");
		            flag = true;
		            break;
		        }
		    }
		    if(flag)continue;
		    System.out.println("YES");
		}
	}
}
