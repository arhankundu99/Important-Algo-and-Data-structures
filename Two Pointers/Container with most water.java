//https://leetcode.com/problems/container-with-most-water/
class Solution {
    public int maxArea(int[] height) {
         int res=0;
        int i=0,j=height.length-1;
        while(i<j)
        {
            res=Math.max(res,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j])i++;
            else j--;
        }
        return res;
    }
}
