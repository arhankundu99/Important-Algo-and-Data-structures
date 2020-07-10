//https://www.interviewbit.com/problems/smallest-multiple-with-0-and-1/
public class Solution {
    public String multiple(int A) {
        String s = "1";
        Queue<String>queue = new LinkedList<>();
        boolean[]vis = new boolean[A];
        queue.add(s);
        
        while(queue.size() != 0){
            String poll = queue.poll();
            int rem = mod(poll, A);
            
            if(rem == 0)return poll;
            
            if(!vis[rem]){
                vis[rem] = true;
                String s1 = poll + "0";
                String s2 = poll + "1";
                queue.add(s1);
                queue.add(s2);
            }
        }
        return "0";
    }
    public int mod(String s, int A){
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            ans = (ans*10) + s.charAt(i) - '0';
            ans %= A;
        }
        return ans;
    }
}
