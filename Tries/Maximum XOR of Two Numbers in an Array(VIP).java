// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/556/week-3-september-15th-september-21st/3462/
class Solution {
    public int findMaximumXOR(int[] nums) {
        trie trie = new trie();
        for(int i = 0; i < nums.length; i++)trie.insert(Integer.toBinaryString(nums[i]));
        
        int max_xor = 0;
        for(int i = 0; i < nums.length; i++){
            int curr_xor = 0;
            
            String s = Integer.toBinaryString(nums[i]);
            String padding = "";
            for(int j = 0; j < 32 - s.length(); j++)padding += "0";
            
            s = padding + s;
            
            node curr = trie.root;
            
            for(int j = 0; j < 32; j++){
                int idx = s.charAt(j) - 48;
                if(curr.children[1-idx] != null){
                    curr_xor += (1<<(32-j-1));
                    curr = curr.children[1-idx];
                }
                else curr = curr.children[idx];
            }
            max_xor = Math.max(max_xor, curr_xor);
        }
        return max_xor;
    }
}
class trie{
    node root;
    trie(){
        root = new node();
    }
    void insert(String s){
        String padding = "";
        for(int i = 0; i < 32 - s.length(); i++)padding += "0";
        s = padding + s;
        node curr = root;
        for(int i = 0; i < s.length(); i++){
            int idx = s.charAt(i) - 48;
            
            if(curr.children[idx] == null)curr.children[idx] = new node();
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
}
class node{
    boolean isEnd;
    node[] children;
    node(){
        isEnd = false;
        children = new node[2];
    }
}
