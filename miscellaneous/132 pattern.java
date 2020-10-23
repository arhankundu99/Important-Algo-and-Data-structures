// https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/562/week-4-october-22nd-october-28th/3505/
class Solution {
    public boolean find132pattern(int[] nums) {
        
        PriorityQueue<Integer>minHeap = new PriorityQueue<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        minHeap.add(nums[0]);
        for(int i = 2; i < nums.length; i++){
            if(map.containsKey(nums[i]))map.put(nums[i], map.get(nums[i])+1);
            else map.put(nums[i], 1);
        }
        
        for(int j = 1; j < nums.length-1; j++){
            int valI = minHeap.peek();
            Integer valK = map.floorKey(nums[j] - 1);
            
            minHeap.add(nums[j]);
            
            if(map.get(nums[j+1]) > 1)map.put(nums[j+1], map.get(nums[j+1])-1);
            else map.remove(nums[j+1]);
            
            if(valK == null)continue;
            
            if(valI < nums[j] && valK < nums[j] && valI < valK)return true;
            
        }
        return false;
    }
}
