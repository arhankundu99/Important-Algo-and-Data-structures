// https://leetcode.com/problems/search-suggestions-system/
class Solution {
    List<List<String>> list;
    int count;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        trie trie = new trie();
        list = new ArrayList<>();
        
        for(int i = 0; i < searchWord.length(); i++)list.add(new ArrayList<>());
        
        for(String product: products)trie.insert(product);
        
        String search = "";
        node currNode = trie.root;
        for(int i = 0; i < searchWord.length(); i++){
            search += searchWord.charAt(i);
            
            int idx = searchWord.charAt(i) - 'a';
            
            if(currNode.children[idx] == null){
                return list;
            }
            else{
                currNode = currNode.children[idx];
                count = 0;
                dfs(currNode, new StringBuilder(search), i);
            }
        }
        
        return list;
    }
    public void dfs(node node, StringBuilder sb, int idx){
        if(node.isEndOfWord){
            count++;
            if(count <= 3)list.get(idx).add(sb.toString());
        }
        
        for(int i = 0; i < 26; i++){
            if(node.children[i] != null){
                char c = (char)('a' + i);
                sb.append(c);
                //System.out.println((char)('a' + i));
                dfs(node.children[i], sb, idx);
                sb.deleteCharAt(sb.length() - 1);
                
                if(count > 3)return;
            }
        }
    }
}
class trie{
    node root = new node();
    
    void insert(String s){
        node currNode = root;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(currNode.children[c - 'a'] == null)currNode.children[c - 'a'] = new node();
            
            currNode = currNode.children[c - 'a'];
        }
        currNode.isEndOfWord = true;
    }
}
class node{
    node[] children;
    boolean isEndOfWord;
    
    public node(){
        children = new node[26];
        isEndOfWord = false;
    }
}
