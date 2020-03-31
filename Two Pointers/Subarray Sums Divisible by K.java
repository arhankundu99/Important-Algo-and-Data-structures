// Problem number 974
//Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
// 1 <= A.length <= 30000
// -10000 <= A[i] <= 10000
// 2 <= K <= 10000

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int currSum = 0;
        int ret = 0;
        for(int i = 0;i < A.length;i++)
        {
            currSum=(currSum+A[i])%K;
            if(currSum<0)currSum+=K;
            if(map.containsKey(currSum))
            {
                ret+=map.get(currSum);
                map.put(currSum,map.get(currSum)+1);
            }
            else map.put(currSum,1);

        }
        return ret;
    }
}
//Idea
// for a subarray nums[0...x] where x lies between 1 to nums.length, if the sum is P,
// we just have to find out number of subarrays nums[0...z] where z lies between 1 to x which have sum P-K
