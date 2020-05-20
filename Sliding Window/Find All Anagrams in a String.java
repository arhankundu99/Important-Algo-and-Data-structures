// leetcode prob 438
// difficulty : medium
//Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer>map = new HashMap<>();
        Set<Character>set = new HashSet<>();
        for(int i=0;i<p.length();i++)
        {
            if(map.containsKey(p.charAt(i)))map.put(p.charAt(i), map.get(p.charAt(i))+1);
            else map.put(p.charAt(i), 1);
            set.add(p.charAt(i));
        }
        
        List<Integer>list = new ArrayList<>();
        int i = 0, j = 0;
        while(j < s.length())
        {
            if(!set.contains(s.charAt(j)))
            {
                while(i<j)
                {
                    if(map.containsKey(s.charAt(i)))map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    else map.put(s.charAt(i),1);
                    i++;
                }
                i++;
                j++;
            } 
            else if(!map.containsKey(s.charAt(j)))
            {
                if(map.containsKey(s.charAt(i)))map.put(s.charAt(i), map.get(s.charAt(i))+1);
                else map.put(s.charAt(i),1);
                i++; 
            }
            else if(map.containsKey(s.charAt(j)))
            {
                if(map.get(s.charAt(j)) == 1)map.remove(s.charAt(j));
                else map.put(s.charAt(j), map.get(s.charAt(j))-1);
                j++;
                if(map.size() == 0)
                {
                    list.add(i);
                    if(!map.containsKey(s.charAt(i)))map.put(s.charAt(i),1);
                    else map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    i++;
                }
            }
        }
        return list;
    }
}
