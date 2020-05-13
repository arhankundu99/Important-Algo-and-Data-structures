// leetcode problem 402
// Given a non-negative integer num represented as a string, 
//remove k digits from the number so that the new number is the smallest possible.

//Greedy Solution: O(nk)
 class Solution {
    public String removeKdigits(String num, int k) {
        for (int i = 1; i <= k; i++)
            num = toRemoveOneDigit(num);
        return num;
    }

    private String toRemoveOneDigit(String num) {
        int length = num.length();
        int index = length - 1;
        for (int i = 0; i < index; i++) {
            if (num.charAt(i) > num.charAt(i + 1)) {
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char digit = num.charAt(i);
            if (sb.length() == 0 && digit == '0' || i == index)
                continue;
            sb.append(digit);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}

// using stack : O(n)
class Solution {
    public String removeKdigits(String num, int k) 
    {
        Stack<Character>stack = new Stack<>();
        
        for(int i=0;i<num.length();i++)
        {
            if(stack.isEmpty() || num.charAt(i) > stack.peek())
            {
                stack.push(num.charAt(i));
                continue;
            }
            else while(!stack.isEmpty() && k>0 && stack.peek() > num.charAt(i))
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while(k > 0)
        {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
        {
            StringBuilder temp = new StringBuilder();
            temp.append(stack.pop());
            temp.append(sb);
            sb = temp;
        }
        int n = sb.length();
        for(int i=0;i<n;i++)
        {
            if(sb.charAt(i) != '0')break;
            sb.deleteCharAt(i);
            i--;
            n--;
        }

        return sb.length() == 0?"0":sb.toString();
    }
}
