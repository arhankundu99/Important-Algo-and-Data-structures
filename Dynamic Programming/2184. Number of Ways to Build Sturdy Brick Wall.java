// https://leetcode.com/problems/number-of-ways-to-build-sturdy-brick-wall/
// https://algo.monster/liteproblems/2184
class Solution {
    int mod = (int)Math.pow(10, 9) + 7;
    public int buildWall(int height, int width, int[] bricks) {
        long[][] dp = new long[height + 1][1 << (width + 1)];
        for (int i = 0; i < height + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int)buildWall(height, width, bricks, 1, 0, 0, 0, dp);
    }

    private long buildWall(int height, int width, int[] bricks, int currHeight, int currWidth, int prevRowState, int currRowState, long[][] dp) {
        if (currHeight == height && currWidth == width) {
            return 1;
        }

        if (currWidth > width || currHeight > height) {
            return 0;
        }

        if (currWidth == 0 && dp[currHeight][prevRowState] != -1) {
            return dp[currHeight][prevRowState];
        }

        if (currWidth == width) {
            return buildWall(height, width, bricks, currHeight + 1, 0, currRowState, 0, dp);
        }

        long count = 0;
        for (int i = 0; i < bricks.length; i++) {
            int nextCurrWidth = currWidth + bricks[i];
            if (nextCurrWidth <= width) {
                int nextCurrRowState = currRowState | (1 << nextCurrWidth);

                // for no intersection and for the end bricks
                if ((prevRowState & nextCurrRowState) == 0 || nextCurrWidth == width) {
                    count += buildWall(height, width, bricks, currHeight, nextCurrWidth, prevRowState, nextCurrRowState, dp);
                    count %= mod;
                }
            }
        }
        // 1010 [1, 2]
        // 1100 [2, 1]
        if (currWidth == 0) {
            dp[currHeight][prevRowState] = count;
        }
        return count;
    }
}