// https://leetcode.com/problems/continuous-subarray-sum/description/
class Solution {

    // we have to find sum % k using hashmap
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            sum += num;


            int find = (sum % k + k) % k;

            if(find == 0 && i >= 1)
                return true;

            if(map.containsKey(find) && map.get(find) <= i - 2){
                return true;
            }
            if(!map.containsKey(find))
                map.put(find, i);
        }
        return false;
    }
}
