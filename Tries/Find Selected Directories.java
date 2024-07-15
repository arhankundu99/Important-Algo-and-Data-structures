// https://leetcode.com/discuss/interview-question/5039879/Google-Onsite-Interview
// I was given (as strings) as directories e.g.
// /a/b/x.txt
// /a/b/p.txt
// /a/c
// /a/d/y.txt
// /a/d/z.txt

// Also, I was given the selected directories e.g.
// /a/d/y.txt
// /a/d/z.txt
// /a/b/p.txt

// My output should be
// /a/d
// /a/b/p.txt

// /a/d
// is the answer because it has 2 txt files (y and z), and both are selected.
// /a/b/p.txt
// is the answer because another file in the directory i.e. /a/b/x.txt is not selected, if it was selected, answer would have been /a/b

// Basically, if all items are selected in a particular directory, we need to return the just prev directory.
import java.util.*;

class TrieNode {
    int count;
    Map<String, TrieNode> children;
    TrieNode() {
        count = 0;
        children = new HashMap<>();
    }
}

class Trie {
    TrieNode root;
    Trie() {
        root = new TrieNode();
    }
    
    void insert(String directory) {
        TrieNode curr = root;
        String[] path = directory.split("/");
        
        for (int i = 0; i < path.length; i++) {
            if (!curr.children.containsKey(path[i])) {
                curr.children.put(path[i], new TrieNode());
            }
            curr.children.get(path[i]).count++;
            curr = curr.children.get(path[i]);
        }
    }
    
    void select(String directory) {
        TrieNode curr = root;
        String[] path = directory.split("/");
        
        for (int i = 0; i < path.length; i++) {
            curr.children.get(path[i]).count--;
            curr = curr.children.get(path[i]);
        }
    }
    
    String getSelectedDirectory(String directory) {
        TrieNode curr = root;
        String[] path = directory.split("/");
        StringBuilder selectedDirectory = new StringBuilder();
        for (int i = 0; i < path.length; i++) {
            curr = curr.children.get(path[i]);
            if (selectedDirectory.length() != 0) {
                selectedDirectory.append("/");
            }
            selectedDirectory.append(path[i]);
            if (curr.count == 0) {
                break;
            }
        }
        return selectedDirectory.toString();
    }
}

class Solution {
    List<String> getSelectedDirectories(String[] directories, String[] selectedDirectories) {
        Trie trie = new Trie();
        for (String directory: directories) {
            trie.insert(directory);
        }
        
        for (String directory: selectedDirectories) {
            trie.select(directory);
        }
        
        List<String> result = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        for (String directory: selectedDirectories) {
            String selection = trie.getSelectedDirectory(directory);
            resultSet.add(selection);
        }
        for (String directory: resultSet) {
            result.add(directory);
        }
        return result;
    }
}
public class Main {
    

    public static void main(String[] args) {
        String[] directories = new String[]{"/a/b/x.txt", "/a/b/p.txt", "/a/c", "/a/d/y.txt", "/a/d/z.txt"};
        
        String[] selectedDirectories = new String[]{"/a/d/y.txt", "/a/d/z.txt", "/a/b/p.txt"};
         
        System.out.println((new Solution()).getSelectedDirectories(directories, selectedDirectories));
    }            
}
