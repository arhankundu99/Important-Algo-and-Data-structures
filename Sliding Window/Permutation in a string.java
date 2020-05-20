// leetcode prob 567
// Difficulty : medium
//Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. 
//In other words, one of the first string's permutations is the substring of the second string.

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer>map=new HashMap<>();
        Set<Character>set = new HashSet<>();
        
        for(int i=0;i<s1.length();i++)
        {
            if(!map.containsKey(s1.charAt(i)))map.put(s1.charAt(i),1);
            else map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            set.add(s1.charAt(i));
        }
        
        int i=0,j=0;
        while(j<s2.length())
        {
            if(!set.contains(s2.charAt(j)))
            {
                while(i<j)
                {
                    if(map.containsKey(s2.charAt(i)))map.put(s2.charAt(i), map.get(s2.charAt(i))+1);
                    else map.put(s2.charAt(i),1);
                    i++;
                }
                i++;
                j++;
            }
            else if(map.containsKey(s2.charAt(j)))
            {
                if(map.get(s2.charAt(j)) == 1)map.remove(s2.charAt(j));
                else map.put(s2.charAt(j), map.get(s2.charAt(j))-1);
                
                if(map.size() == 0)return true;
                j++;
            }
            else if(!map.containsKey(s2.charAt(j)))
            {
                if(map.containsKey(s2.charAt(i)))map.put(s2.charAt(i), map.get(s2.charAt(i))+1);
                else map.put(s2.charAt(i),1);
                i++;
            }
        }
        return false;
    }
}
