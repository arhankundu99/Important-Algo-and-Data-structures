// https://leetcode.com/problems/string-to-integer-atoi/description/
class Solution {
    public int myAtoi(String s) {
        // remove any leading or trailing white space
        s = s.trim();

        // check the sign
        char sign = '+';
        if(s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
            sign = s.charAt(0);
            s = s.substring(1);
        }

      
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            // stop the reading if the current character is a non digit
            
            if(!isDigit(s.charAt(i)))
                break;

            int digit = s.charAt(i) - 48;
            

            // check if this digit can be appended without going out of range.
            if(sign == '+'){
                if(num <= (Integer.MAX_VALUE - digit) / 10)
                    num = (num * 10) + digit;
                else{
                    num = Integer.MAX_VALUE;
                    break;
                }
            }

            else{
                
                if(-num >= (Integer.MIN_VALUE + digit) / 10)
                    num = (num * 10) + digit;
                else{
                    num = Integer.MIN_VALUE;
                    break;
                }
            }
        }

        if(num == 0)
            return 0;
        
        return sign == '-'? -num: num;
    }

    private boolean isDigit(char c){
        return c >= 48 && c <= 57;
    }
}
