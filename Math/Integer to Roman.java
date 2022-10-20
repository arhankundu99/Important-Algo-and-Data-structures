// https://leetcode.com/problems/integer-to-roman/

class Solution {
    public String intToRoman(int num) {
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        String roman = "";
        for(int i = 0; i < values.length && num > 0; i++){
            while(num >= values[i]){
                roman += romans[i];
                num -= values[i];
            }
        } 

        return roman;
    }
}
