class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        trie trie = new trie();
        for(String s: strs)trie.insert(s);
        
        node curr = trie.root;
        int idx2 = -1;
        for(int i = 0; i < strs[0].length(); i++){
            int idx = strs[0].charAt(i) - 97;
            if(curr.children[idx].count == strs.length){
                idx2 = i;
                curr = curr.children[idx];
            }
            
            else break;
        }
        return strs[0].substring(0, idx2 + 1);
    }
}
class trie{
    node root;
    trie(){
        root = new node();
    }
    
    void insert(String word){
        node curr = root;
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 97;
            if(curr.children[idx] == null)curr.children[idx] = new node();
            curr = curr.children[idx];
            curr.count++;
        }
        curr.isEndOfWord = true;
    }
}
class node{
    boolean isEndOfWord;
    node[] children;
    int count;
    node(){
        children = new node[26];
        isEndOfWord = false;
        count = 0;
    }
}
