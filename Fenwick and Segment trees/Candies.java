// Kickstart round C ques 4
// link: https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff43/0000000000337b4d
import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=1;i<=t;i++)
            System.out.println("Case #"+i+": "+solve(scan));
    }
    public static int solve(Scanner scan)
    {
        int n = scan.nextInt();
        int q = scan.nextInt();
        
        int[]a = new int[n+1];
        
        for(int i=1;i<=n;i++)a[i] = scan.nextInt();
        
        fenwick[] f = new fenwick[2];
        f[0] = new fenwick();
        f[1] = new fenwick();
        int ans = 0, sign = 1;
        
        for(int i=1;i<=n;i++)
        {
            f[0].update(i, sign*a[i]);
            f[1].update(i, (i)*sign*a[i]);
            sign = -sign;
        }
        for(int i=0;i<q;i++)
        {
            String s = scan.next();
            if(s.equals("Q"))
            {
                int l = scan.nextInt();
                int r = scan.nextInt();
                sign = 1;
            
                int sum1 = f[1].query(r)-f[1].query(l-1);
                int sum2 = f[0].query(r)-f[0].query(l-1);
                
                int sum = sum1 - (l-1)*sum2;
            
                if(l%2 == 0)sum *= -1;
            
                ans += sum;
            }
            else
            {
                int idx = scan.nextInt();
                int val = scan.nextInt();
            
                sign = 1;
            
                if(idx % 2 == 0)sign = -1;
                
            
                f[0].update(idx, -sign*a[idx]);
                f[1].update(idx, -sign*idx*a[idx]);
                
                a[idx] = val;
                
                f[0].update(idx, sign*a[idx]);
                f[1].update(idx, sign*idx*a[idx]);
            }
        }
        return ans;
    }
}
class fenwick
{
    int[]ft;
    int size = 200005;
    fenwick()
    {
        ft = new int[size];
    }
    void update(int idx, int val)
    {
        while(idx < ft.length)
        {
            ft[idx] += val;
            idx += idx&(~(idx)+1);
        }
    }
    int query(int idx)
    {
        int sum = 0;
        while(idx > 0)
        {
            sum += ft[idx];
            idx -= idx&(~(idx)+1);
        }
        return sum;
    }
}
