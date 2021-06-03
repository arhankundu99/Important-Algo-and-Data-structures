// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
class Solution {
    int mod = 1000000007;
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        Arrays.sort(hc);
        Arrays.sort(vc);
        
        long maxWidth = vc[0];
        
        for(int i = 1; i < vc.length; i++)maxWidth = Math.max(maxWidth, vc[i] - vc[i - 1]);
        maxWidth = Math.max(maxWidth, w - vc[vc.length - 1]);
        
        long maxHeight = hc[0];
        
        for(int i = 1; i < hc.length; i++)maxHeight = Math.max(maxHeight, hc[i] - hc[i - 1]);
        maxHeight = Math.max(maxHeight, h - hc[hc.length - 1]);    
        
        long maxArea = (maxWidth * maxHeight) % mod;
        
        return (int)maxArea;
    }
}
