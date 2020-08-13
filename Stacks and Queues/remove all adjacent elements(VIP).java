// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution {
    public String removeDuplicates(String S, int k) {
        Stack<pair>stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < S.length(); i++){
            if(stack.size() == 0){
                stack.push(new pair(S.charAt(i), 1));
            }
            else if(S.charAt(i) == stack.peek().character){
                if(stack.peek().freq == k-1)stack.pop();
                else{
                    pair pair = stack.pop();
                    pair.freq++;
                    stack.push(pair);
                }
            }
            else stack.push(new pair(S.charAt(i), 1));
        }
        
        while(stack.size() != 0){
            pair pair = stack.pop();
            while(pair.freq != 0){
                sb.append(pair.character);
                pair.freq--;
            }
        }
        return sb.reverse().toString();
    }
}
class pair{
    char character;
    int freq;
    pair(char character, int freq){
        this.character = character;
        this.freq = freq;
    }
}
