// https://leetcode.com/problems/ugly-number-iii/description/
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 0, high = 2 * (long)Math.pow(10, 9);
        long num = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;

            long count = (mid / a) + (mid / b) + (mid / c) - (mid / lcm(a, b)) - (mid / lcm(b, c)) - (mid / lcm(a, c)) + (mid / lcm(a, b, c));

            if (count >= n) {
                num = mid;
                high = mid - 1; 
            } else {
                low = mid + 1;
            }
        }
        return (int)num;
    }

    private long lcm(int a, int b) {
        return (1L * a * b) / gcd(a, b);
    }

    private long lcm(int a, int b, int c) {
        return (1L * a * lcm(b, c)) / gcd(a, lcm(b, c));
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } 
        return gcd(b, a % b);
    }
}