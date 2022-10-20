// https://leetcode.com/problems/roman-to-integer/
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int romanInt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(i + 1 < s.length()){
                char c2 = s.charAt(i + 1);

                if(map.get(c) < map.get(c2))
                    romanInt -= map.get(c);
                else romanInt += map.get(c);
            }
            else romanInt += map.get(c);
        }
        return romanInt;
    }
}
