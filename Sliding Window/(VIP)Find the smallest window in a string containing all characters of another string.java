/*package whatever //do not write package name here */
//https://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
//Given two strings string1 and string2, the task is to find the smallest substring in string1 containing all characters of string2 efficiently.
// very important

/*package whatever //do not write package name here */
// https://leetcode.com/problems/minimum-window-substring/

class Solution {
    public String minWindow(String s, String t) {
        int i = 0, j = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int x = 0; x < t.length(); x++){
            if(!map.containsKey(t.charAt(x)))map.put(t.charAt(x), 1);
            else map.put(t.charAt(x), map.get(t.charAt(x))+1);
        }
        int count = t.length(), minLength = Integer.MAX_VALUE, idx1 = -1, idx2 = -1;
        while(j < s.length()){
            
            if(map.containsKey(s.charAt(j))){
                if(map.get(s.charAt(j)) > 0)count--;
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
            }
            if(count == 0){
                while(i <= j){
                    if(map.containsKey(s.charAt(i))){
                        if(map.get(s.charAt(i)) == 0)break;
                        map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    }
                    i++;
                }
            }
            if(count == 0 && maxLength > j - i + 1){
                minLength = j - i + 1;
                idx1 = i;
                idx2 = j;
            }
            j++;
        }
        return idx1 == -1?"": s.substring(idx1, idx2+1);
    }
}
