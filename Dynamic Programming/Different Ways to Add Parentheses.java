// https://leetcode.com/problems/different-ways-to-add-parentheses/
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            
            if(c == '+' || c == '-' || c == '*'){
                String part1 = input.substring(0, i);
                String part2 = input.substring(i+1, input.length());
                
                List<Integer> list1 = diffWaysToCompute(part1);
                List<Integer> list2 = diffWaysToCompute(part2);
                
                for(int p: list1){
                    for(int q: list2){
                        if(c == '+')list.add(p+q);
                        if(c == '-')list.add(p-q);
                        if(c == '*')list.add(p*q);
                    }
                }
            }
        }
        if(list.size() == 0)list.add(Integer.valueOf(input));
        return list;
    }
}
