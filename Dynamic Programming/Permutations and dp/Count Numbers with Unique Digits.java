// https://leetcode.com/problems/count-numbers-with-unique-digits/
// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)return 1;
        if(n == 1)return 10;
        if(n == 2)return 91;
        int[] count = new int[n+1];
        count[1] = 10;
        count[2] = 81;
        for(int i = 3; i <= n; i++){
            count[i] = count[i-1]*(10- (i - 1));
        }
        int ans = 0;
        for(int i = 1; i <= n; i++)ans += count[i];
        return ans;
    }
}
