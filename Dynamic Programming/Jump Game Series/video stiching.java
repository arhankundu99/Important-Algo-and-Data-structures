https://leetcode.com/problems/video-stitching/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] arr = new int[T+1];
        
        for(int i = 0; i < clips.length; i++){
            int left = Math.min(T, clips[i][0]);
            int right = clips[i][1];
            
            arr[left] = Math.max(arr[left], right);
        }
        int currEnd = 0, currFarthest = 0, jumps = 0;
        
        for(int i = 0; i < arr.length; i++){
            if(i > currFarthest)return -1;
            
            currFarthest = Math.max(currFarthest, arr[i]);
            
            if(i == currEnd && i != T){
                currEnd = currFarthest;
                jumps++;
            }
        }
        return jumps;
    }
}
