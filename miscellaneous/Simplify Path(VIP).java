// https://leetcode.com/problems/simplify-path/
class Solution {
    public String simplifyPath(String path) {
        String[] splitPath = path.split("/");
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0; i < splitPath.length; i++){
            String s = splitPath[i];
            if(s.length() == 0 || s.equals("."))continue;
           // System.out.println(s);
            if(s.equals("..")){
                if(stack.size() != 0)stack.pop();
            }
            else stack.push(s);
        }
        
        StringBuilder sb = new StringBuilder();
        
        if(stack.size() != 0){
            while(stack.size() != 1){
                sb.insert(0, stack.pop());
                sb.insert(0, "/");
            }
            sb.insert(0, stack.pop());
        }
        
        String simplifiedPath = "/" + sb.toString();
        return simplifiedPath;
    }
}
