// https://leetcode.com/problems/prime-subtraction-operation/description/
class Solution {
    public boolean primeSubOperation(int[] nums) {
        int maxValue = 0;
        for (int num: nums) {
            maxValue = Math.max(maxValue, num);
        }
        boolean[] isPrime = new boolean[maxValue + 1];
        Arrays.fill(isPrime, true);

        int currNum = 2;
        while (currNum * currNum < isPrime.length) {

            if (isPrime[currNum]) {
                for (int i = currNum * currNum; i < isPrime.length; i += currNum) {
                    isPrime[i] = false;
                }
            }
            currNum++;
        }

        int[] primePrefixSum = new int[isPrime.length];
        for (int i = 2; i < isPrime.length; i++) {
            primePrefixSum[i] = primePrefixSum[i - 1] + (isPrime[i]? 1: 0);
        }

        for (int i = 0; i < nums.length; i++) {
            // Find the highest prime number with higher bound nums[i] - 1 and lower bound nums[i - 1] + 1
            // nums[i] - prime > nums[i - 1] => prime < nums[i] - nums[i - 1] => prime = [2, nums[i] - nums[i - 1] - 1]
            int left = 2, right = nums[i] - (i > 0? nums[i - 1]: 0) - 1;
            // System.out.println(left + " " + right);
            int targetPrime = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                // Check if any prime exists in [mid, right]
                int countPrimesInRight = primePrefixSum[right] - (mid != 0? primePrefixSum[mid - 1]: 0);

                if (countPrimesInRight > 0) {
                    targetPrime = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                
            }
            if (targetPrime != -1) {
                nums[i] = nums[i] - targetPrime;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}