// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length == 0 || k == 0)return false;
        k = Math.min(k, nums.length-1);
        
        long[] arr = new long[nums.length];
        for(int i = 0; i < nums.length; i++)arr[i] = nums[i];
        
        TreeMap<Long, Integer> map = new TreeMap<>();
        
        for(int i = 1; i <= k; i++){
            if(map.containsKey(arr[i]))map.put(arr[i], map.get(arr[i])+1);
            else map.put(arr[i], 1);
        }
        
        Long ceil = map.ceilingKey(arr[0] - t);
        Long floor = map.floorKey(arr[0] + t);
        
        if((ceil != null && ceil <= arr[0]+t) || (floor != null && floor >= arr[0]+t))return true;
        
        for(int i = 1; i < arr.length; i++){
            if(map.get(arr[i]) == 1)map.remove(arr[i]);
            else map.put(arr[i], map.get(arr[i])-1);
    
            if(i+k < arr.length){
                if(map.containsKey(arr[i+k]))map.put(arr[i+k], map.get(arr[i+k])+1);
                else map.put(arr[i+k], 1);
            }
            
            ceil = map.ceilingKey(arr[i] - t);
            floor = map.floorKey(arr[i] + t);
            
            if((ceil != null && ceil <= arr[i]+t) || (floor != null && floor >= arr[i]+t)){
                return true;
            }
        }
        return false;
        
    }
}
