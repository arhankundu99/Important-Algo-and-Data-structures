// https://leetcode.com/problems/nth-magical-number/description/

class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    
    public int nthMagicalNumber(int n, int a, int b) {
        //let magical number be m
        //Then the number of numbers in the range [1, m] that are divisible by a is lowerBound(m / a)
        //Similarly the number of numbers in the range [1, m] that are divisible by b is lowerBound(m / b)
        //And the number of numbers that are both divisible by a and b in the range [1, m] is lowerBound(m / lcm(a, b))
        
        //Therefore the equation 
        //lowerBound(m / a) + lowerBound(m / b) - lowerBound(m / lcm(a, b)) = n
        //where m is either divisible by a or b or both
        
        //How to find the value of m?
        //Do we know the lower bound of m? Yes! lowerBound(m) should be min(a, b);
        //Do we know the higher bound of m? Also Yes! higherBound(m) would never exceed n * max(a, b)
        
        //We know the lowerBound and higherBound of m. So we can effectively apply binary search algorithm 
        
        int lcm = lcm(a, b);
        
        long lowerBound = Math.min(a, b), higherBound = 1L * Math.max(a, b) * n;
        
        int nthMagicalNumber = -1;
        
        while(lowerBound <= higherBound){
            long m = lowerBound + (higherBound - lowerBound) / 2;
            
            long kthMagicalNumber = (m / a) + (m / b) - (m / lcm);
            
            if(kthMagicalNumber == n){
                nthMagicalNumber = (int)(m % mod);
                higherBound = m - 1;
            }
            else if(kthMagicalNumber > n){
                higherBound = m - 1;
            }
            else lowerBound = m + 1;
        }
        return nthMagicalNumber;
    }
    
    int lcm(int a, int b){
        return (a * b) / gcd(a, b);
    }
    
    int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b, a % b);
    }
}
