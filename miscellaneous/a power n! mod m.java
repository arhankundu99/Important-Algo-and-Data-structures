// https://codingcompetitions.withgoogle.com/kickstart/round/0000000000201b7d/0000000000201c03#problem
import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i = 1; i <= t; i++){
            int a = scan.nextInt();
            int n = scan.nextInt();
            int p = scan.nextInt();
            
            int ans = a;
            
            for(int j = 1; j <= n; j++){
                ans = pow(ans, j, p);
            }
            System.out.println("Case #"+i+": "+ans);
        }
    }
    public static int pow(int a, int b, int m){
        if(b == 0)return 1;
        
        int x = pow(a, b/2, m);
        
        x = (int)((1L*x*x) % m);
        
        if(b % 2 != 0)x = (int)((1L*x*a) % m);
        
        return x;
    }

}
