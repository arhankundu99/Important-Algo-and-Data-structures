//https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0, j = 0, minWindowSize = Integer.MAX_VALUE;
        int minWindowIdx1 = -1, minWindowIdx2 = -1;

        while(j < s.length()){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
            }

            if(isSubStringFound(map)){
                while(i < j){
                    if(map.containsKey(s.charAt(i))){
                        if(map.get(s.charAt(i)) == 0)break;
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    }
                    i++;
                }

                int windowSize = j - i + 1;
                if(minWindowSize > windowSize){
                    minWindowSize = windowSize;
                    minWindowIdx1 = i;
                    minWindowIdx2 = j;
                }
            }
            j++;
        }

        return minWindowSize == Integer.MAX_VALUE? "": s.substring(minWindowIdx1, minWindowIdx2 + 1);
    }

    public boolean isSubStringFound(Map<Character, Integer> map){
        for(Character key: map.keySet()){
            if(map.get(key) > 0)
                return false;
        }
        return true;
    }
}
