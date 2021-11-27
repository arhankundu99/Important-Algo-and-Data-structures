// https://leetcode.com/problems/random-pick-with-weight/
class Solution {
    Random random;
    int[] cummW;
    public Solution(int[] w) {
        random = new Random();
        cummW = new int[w.length];
        
        cummW[0] = w[0];
        for(int i = 1; i < w.length; i++)cummW[i] = cummW[i - 1] + w[i];
    }
    
    public int pickIndex() {
        // pick a random number between 1 and cummW[cummW.length - 1];
        int randomWeight = random.nextInt(cummW[cummW.length - 1]) + 1;
        
        //using binarySearch find the idx whose cumm weight is just greater or equal to randomWeight
        int idx = binarySearch(cummW, randomWeight);
        return idx;
    }
    
    private int binarySearch(int[] arr, int val){
        int idx = -1;
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(arr[mid] >= val){
                idx = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        
        return idx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
