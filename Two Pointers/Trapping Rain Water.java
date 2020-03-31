//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.

Brute Force (O(n^2) Solution)
class Solution {
    public int trap(int[] height) {
        int ret = 0;
        for(int i = 0;i < height.length-1;i++)
        {
            if(height[i+1] >= height[i])continue;
            
            int rightMax = 0;
            int idx = i;
            for(int j = i+1;j < height.length;j++)
            {
                if(rightMax <= height[j])
                {
                    rightMax = height[j];
                    idx = j;
                }
                if(rightMax > height[i])break;
            }
            ret += Math.min(height[i],height[idx])*(idx-i-1);
            
            for(int j = i+1;j < idx;j++)ret -= height[j];
            i = idx-1;
        }
        return ret;
    }
}
