// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/606/week-4-june-22nd-june-28th/3788/
// the problem can be solved using binary search instead of the ceiling function
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < 26; i++)map.put(i, new TreeSet<>());
        
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 'a';
            map.get(idx).add(i);
        }        
        int count = 0;
        for(String word: words)
        {
            int prevIdx = -1;
            
            for(int i = 0; i < word.length(); i++){
                int idx = word.charAt(i) - 'a';
                
                if(map.get(idx).ceiling(prevIdx + 1) == null)break;
                prevIdx = map.get(idx).ceiling(prevIdx + 1);
                
                if(i == word.length() - 1)count++;
            }
        }
        return count;
    }
}
