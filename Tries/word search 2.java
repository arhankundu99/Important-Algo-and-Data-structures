Leetcode prob 212
Difficulty: HARD

//Given a 2D board and a list of words from the dictionary, find all words in the board.
//Each word must be constructed from letters of sequentially adjacent cell, 
//where "adjacent" cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once in a word.


class Solution {
    Set<String>ret;
    trie trie;
    public List<String> findWords(char[][] board, String[] words) {
        
        ret = new HashSet<>();
        trie = new trie();
        
        for(int i = 0; i < words.length; i++)trie.add(words[i]);
        
        boolean[][]visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++)
                dfs(i,j,visited,new StringBuilder(), board);

        return new ArrayList(ret);
    }
    public void dfs(int r, int c, boolean[][]vis, StringBuilder sb, char[][] board)
    {
        if(r == vis.length || r < 0 || c == vis[0].length || c < 0 || vis[r][c])return;
        
        sb.append(board[r][c]);
        vis[r][c] = true;
        
        if(trie.search(sb))ret.add(sb.toString());
        
        if(!trie.isPrefix(sb))
        {
            sb.deleteCharAt(sb.length()-1);
            vis[r][c] = false;
            return;
        }
        
        dfs(r-1, c, vis, sb, board);
        dfs(r+1, c, vis, sb, board);
        dfs(r, c+1, vis, sb, board);
        dfs(r, c-1, vis, sb, board);
        
        sb.deleteCharAt(sb.length()-1);
        vis[r][c] = false;
    }
}
class trie
{
    trie_node root;
    trie()
    {
        root = new trie_node();
    }
    void add(String s)
    {
        trie_node curr = root;
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 97;
            if(curr.children[idx] == null)curr.children[idx] = new trie_node();
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
    boolean search(StringBuilder s)
    {
        trie_node curr = root;
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 97;
            if(curr.children[idx] == null)return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }
    boolean isPrefix(StringBuilder s)
    {
        trie_node curr = root;
        for(int i = 0; i < s.length(); i++)
        {
            int idx = s.charAt(i) - 97;
            if(curr.children[idx] == null)return false;
            curr = curr.children[idx];
        }
        return true;
    }
}
class trie_node
{
    boolean isEnd;
    trie_node[] children;
    trie_node()
    {
        isEnd = false;
        children = new trie_node[26];
    }
}
