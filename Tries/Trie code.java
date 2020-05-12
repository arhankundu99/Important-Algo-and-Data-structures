//The first line of input contains a single integer T denoting the number of test cases. Then T test cases follow. 
//Each test case consists of three lines.
//First line of each test case consist of a integer N, denoting the number of element in a Trie to be stored.
//Second line of each test case consists of N space separated strings denoting the elements to be stored in the trie.
//Third line of each test case consists of a String A to be searched in the stored elements.

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while(t-->0)
	    {
	        trie trie = new trie();
	        int n = scan.nextInt();
	        for(int i=0;i<n;i++)
	            trie.insert(scan.next());
	        if(trie.search(scan.next()))
	            System.out.println(1);
	        else System.out.println(0);
	    }
	}
}
class trie
{
    node root = new node();
    
    void insert(String s)
    {
        node currNode = root;
        for(int i=0;i<s.length();i++)
        {
            int idx = s.charAt(i)-97;
            if(currNode.children[idx] == null)
                currNode.children[idx] = new node();
            currNode = currNode.children[idx];
        }
        currNode.isEndOfWord = true;
    }
    boolean search(String s)
    {
        node currNode = root;
        for(int i=0;i<s.length();i++)
        {
            int idx = s.charAt(i)-97;
            if(currNode.children[idx] == null)return false;
            currNode = currNode.children[idx];
        }
        return currNode.isEndOfWord;
    }
}
class node
{
    char val;
    node[] children = new node[26];
    boolean isEndOfWord;
    node()
    {
        for(int i=0;i<26;i++)children[i] = null;
        isEndOfWord = false;
    }
}
