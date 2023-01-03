// https://leetcode.com/problems/reverse-integer/

class Solution {
    public int reverse(int x) {
        int num = x, reversedNum = 0;

        while(num != 0){
            int lastDigit = (num % 10);

            if(x > 0 && reversedNum > (Integer.MAX_VALUE - lastDigit) / 10)
                return 0;
            
            if(x < 0 && reversedNum < (Integer.MIN_VALUE - lastDigit) / 10)
                return 0;

            reversedNum = (reversedNum * 10) + lastDigit;

            if((reversedNum > 0 && x < 0) || (reversedNum < 0 && x > 0))
                return 0;

            num = num / 10;
        }

        return reversedNum;
    }
}
