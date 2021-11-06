// https://leetcode.com/problems/number-of-1-bits/description/
// https://leetcode.com/problems/number-of-1-bits/discuss/55099/Simple-Java-Solution-Bit-Shifting
// https://leetcode.com/problems/number-of-1-bits/discuss/55255/C++-Solution:-n-and-(n-1)
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
       int count = 0;
       while(n != 0){
          n &= n - 1;
          count++;
       }
       return count;                    
    }
}
