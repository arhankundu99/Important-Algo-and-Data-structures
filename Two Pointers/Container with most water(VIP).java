//https://leetcode.com/problems/container-with-most-water/
//Two pointer technique is used
//lets say l = 0 and r = n-1
//so the are would be width * Min(height[l], height[r])
//now if l < r, then that means that this is already the largest container the left one can possibly form. so we increase l
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
