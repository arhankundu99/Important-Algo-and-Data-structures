// https://leetcode.com/problems/super-pow/
class Solution {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        int ans = 1;
		    a %= mod;
        
		    //suppose a = 3 and b = [1, 2, 3, 4]
		    //when i = 0, ans = 3 ^ 1
		    //when i = 1, ans = ((3 ^ 1) ^ 10) * (3 ^ 2)) = 3 ^ (12)
		    //when i = 2, ans = ((3 ^ 12) ^ 10) * (3 ^ 3)) = 3 ^ (123) and so on....
        for(int i = 0; i < b.length; i++){
            ans = (pow(ans, 10) * pow(a, b[i])) % mod;
        }
        return ans;
    }
	// power function to calculate (a^b) % mod recursively (O(log(b)) time)
    public int pow(int a, int b){
        if(b == 0)return 1;
        if(b == 1)return a;
        
        int sqrt = pow(a, b/2) % mod;
    
        if(b % 2 == 0)return mult(sqrt, sqrt);
        return mult(a, mult(sqrt, sqrt));
    }
    
    public int mult(int a, int b){
        return (int)((1L * a * b) % mod);
    }
}
