// https://leetcode.com/discuss/interview-question/5031296/Google-or-Technical-Phone-Screen-Round-or-2024
// Given a array of bytes (c++ string or char array or unit_8 array).

// Please find a shortest byte sequence that does not present in the input array.

// assume that "byte" contains only "a" to "f"
// input: "abcdefacbeddefd"

// "a" is present
// "b" is present
// ..
// "f" is present
// "aa" is not present
// "ab" is present
// "ac" is present

// you can return "aa" or "ad" or "ae"... "ff"
// but not "ab" "ac" "bc"

// testcases
// input - aabcdf
// output - e
// Check for single byte shortest byte sequence a,b,c, .... f

// input - abcdefacbeddefd
// output - aa
// check for aa, ab, ac, .... ff

// input - abcdefacbeddefdaabbccddeeff
// output - ab

// input contains arbitrary bytes ('\x00' to '\xff'), not only letters
// small testcase: input length <= 16MB
// large testcase: input length <= 4GB

// you have 8GB ram

import java.util.*;
class TrieNode {
    TrieNode[] children;
    TrieNode() {
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    
    void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 97] == null) {
                curr.children[word.charAt(i) - 97] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 97];
        }
    }
    
    String dfs(int length) {
        StringBuilder missingResult = new StringBuilder();
        if(dfs(root, length, missingResult)) {
            return missingResult.toString();
        }
        return "";
    } 
    
    private boolean dfs(TrieNode curr, int length, StringBuilder missingResult) {
        if (missingResult.length() == length) {
            return false;
        }
        for (char c = 'a'; c <= 'f'; c++) {
            if (curr.children[c - 97] == null) {
                missingResult.append(c);
                return true;
            }
            missingResult.append(c);
            if (dfs(curr.children[c - 97], length, missingResult)) {
                return true;
            }
            missingResult.deleteCharAt(missingResult.length() - 1);
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        String s = "abcdefacbeddefd";
        Trie trie = new Trie();
        for (int length = 1; length <= s.length(); length++) {
            for (int start = 0; start + length <= s.length(); start++) {
                trie.insert(s.substring(start, start + length));
            }
            String missingResult = trie.dfs(length);
            if (missingResult.length() != 0) {
                System.out.println(missingResult);
                return;
            }
        }
    }
}