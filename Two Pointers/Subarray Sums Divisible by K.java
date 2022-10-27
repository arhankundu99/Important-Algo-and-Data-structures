// Problem number 974
//Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
// 1 <= A.length <= 30000
// -10000 <= A[i] <= 10000
// 2 <= K <= 10000

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0, count = 0;

        map.put(0, 1);

        for(int num: nums){
            sum += num;
            int rem = (((sum % k) + k) % k);
            if(map.containsKey(rem)){
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
//Idea
// for a subarray nums[0...x] where x lies between 1 to nums.length, if the sum is P,
// we just have to find out number of subarrays nums[0...z] where z lies between 1 to x which have sum P-K
