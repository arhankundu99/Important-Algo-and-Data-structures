// https://leetcode.com/problems/longest-well-performing-interval/
class Solution {
    public int longestWPI(int[] hours) {
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < hours.length; i++){
            if(hours[i] > 8)sum++;
            else sum--;
            
            if(sum > 0)max = i + 1;
            else if(map.containsKey(sum - 1))max = Math.max(max, i - map.get(sum - 1));
            // why are we looking for sum - 1 and not sum - 2 or sum - 3 or so on
            // because sum - 1 is closer to the origin than sum - 2 or sum - 3 (Assuming origin to be 0th idx)
            
            if(!map.containsKey(sum))map.put(sum, i);
        }
        return max;
    }
}
// follow up: Find the max length of subarray with positive sum 
