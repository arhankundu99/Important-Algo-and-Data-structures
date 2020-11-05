//Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
//leetcode 96 medium

class Solution {
    public int numTrees(int n) {
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        for(int i = 1; i <= n; i++)
            for(int j = 0; j < i; j++)
                catalan[i] += catalan[j]*catalan[i-j-1];
        return catalan[n];
    }
}
//See this for explanation: https://leetcode.com/problems/unique-binary-search-trees/discuss/703049/Python-Math-oneliner-O(n)-using-Catalan-number-explained
