// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3777/
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < words.length; i++)map.put(words[i], i);
        
        //case1: if empty string exists, add all palindromes
        if(map.containsKey(""))
        {
            int blankIdx = map.get("");
            for(int i = 0; i < words.length; i++){
                if(isPalindrome(words[i])){
                    if(i == blankIdx)continue;
                    res.add(Arrays.asList(i, blankIdx));
                    res.add(Arrays.asList(blankIdx, i));
                }
            }
        }
        
        for(int i = 0; i < words.length; i++){
            String currString = reverse(words[i]);
            
            if(map.containsKey(currString) && i != map.get(currString))res.add(Arrays.asList(i, map.get(currString)));
            
            for(int cut = 1; cut < currString.length(); cut++){
                if(isPalindrome(currString.substring(0, cut))){
                     //find a string that is palindrome with substring(cut, currString.length())
                    Integer find = map.get(currString.substring(cut));
                    
                    if(find != null)res.add(Arrays.asList(i, find));
                }
                if(isPalindrome(currString.substring(cut))){
                     //find a string that is palindrome with substring(0, cut)
                    Integer find = map.get(currString.substring(0, cut));
                    
                    if(find != null)res.add(Arrays.asList(find, i));
                }
            }
        }
        
        return res;
    }
    
    public String reverse(String s){
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length / 2; i++)swap(c, i, c.length - i - 1);
        return String.valueOf(c);
    }
    public void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }
                                           
    public boolean isPalindrome(String s){
        int i = 0, j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))return false;
            i++;
            j--;
        }
        return true;
    }
}
