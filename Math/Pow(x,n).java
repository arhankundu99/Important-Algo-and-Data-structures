// Implement pow(x, n), which calculates x raised to the power n.
class Solution {
    public double myPow(double x, int n) {
        if(n<0)x=1/x;
        return pow(x,n);
    }
    public double pow(double x,int n)
    {
        if(n==0)return 1;
        double p=pow(x,n/2);
        if(n%2!=0)return p*p*x;
        return p*p;
    }
}
// Time complexity O(log n)
