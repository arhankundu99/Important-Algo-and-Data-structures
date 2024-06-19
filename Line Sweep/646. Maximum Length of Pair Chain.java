// https://leetcode.com/problems/maximum-length-of-pair-chain/
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[1] - pair2[1];
            }
        });

        int count = 1;
        int prevEnd = pairs[0][1];

        for(int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > prevEnd) {
                count++;
                prevEnd = pairs[i][1];
            }
        }

        return count;
    }
}