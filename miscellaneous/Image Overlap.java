// https://leetcode.com/problems/image-overlap/description/
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maxOverlap = Math.max(maxOverlap, getOverlap(img1, img2, i, j, n));
                maxOverlap = Math.max(maxOverlap, getOverlap(img1, img2, -i, j, n));
                maxOverlap = Math.max(maxOverlap, getOverlap(img1, img2, -i, -j, n));
                maxOverlap = Math.max(maxOverlap, getOverlap(img1, img2, i, -j, n));
            }
        }
        return maxOverlap;
    }

    public int getOverlap(int[][] img1, int[][] img2, int rShift, int cShift, int n){
        
        int overlap = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i + rShift >= n || j + cShift >= n || i + rShift < 0 || j + cShift < 0)continue;
                if(img1[i + rShift][j + cShift] == img2[i][j] && img2[i][j] == 1)
                    overlap++;
            }
        }
        return overlap;
    }
}
