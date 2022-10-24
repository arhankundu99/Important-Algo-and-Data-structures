// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/
class Solution {
    private Map<Integer, Map<Integer, Integer>> dp;
    public int maxLength(List<String> arr) {
        dp = new HashMap<>();
        return maxLength(arr, 0, 0);
    }

    private int maxLength(List<String> arr, int idx, int mask){
        if(idx == arr.size())
            return 0;

        if(dp.containsKey(idx) && dp.get(idx).containsKey(mask))
            return dp.get(idx).get(mask);

        if(!dp.containsKey(idx))
            dp.put(idx, new HashMap<>());

        
        String s = arr.get(idx);


        boolean flag = false;
        int mask2 = mask;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if((mask2 & (1 << (c - 97))) != 0){
                flag = true;
                break;
            }
            mask2 |= (1 << (c - 97));
        }

        if(!flag){
            dp.get(idx).put(mask, Math.max(arr.get(idx).length() + maxLength(arr, idx + 1, mask2), maxLength(arr, idx + 1, mask)));
        }
        
        else dp.get(idx).put(mask, maxLength(arr, idx + 1, mask));

        return dp.get(idx).get(mask);
    }
}
