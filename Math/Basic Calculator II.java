// // https://leetcode.com/problems/basic-calculator-ii/
class Solution {
    public int calculate(String s) {
        int currentOperand = 0;
        int num = 0;
        int result = 0;
        int prevNum = 0;
        char operator = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            } if (s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                num = (num * 10) + (s.charAt(i) - 48);
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
                if (operator == '+' || operator == '-') {
                    if (operator == '+'){
                        result += num;
                        prevNum = num;
                    } else {
                        result -= num;
                        prevNum = -num;
                    }
    
                } else {
                    result -= prevNum;
                    if (operator == '*') {
                        result += prevNum * num;
                        prevNum = prevNum * num;
                    } else {
                        result += prevNum / num;
                        prevNum = prevNum / num;
                    } 
                }
                operator = s.charAt(i);
                num = 0;
            }
        }

        if (operator == '+') {
            result += num;
        } else if (operator == '-') {
            result -= num;
        } else if (operator == '*') {
            result -= prevNum;
            result += prevNum * num;
        } else {
            result -= prevNum;
            result += prevNum / num;
        }
        return result;
    }
}