// prob no 1306
//Given an array of non-negative integers arr, you are initially positioned at start index of the array. 
//When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
//Notice that you can not jump outside of the array at any time.


class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean[]visited = new boolean[arr.length];
        return dfs(arr, start, visited);
    }
    public boolean dfs(int[]arr, int idx, boolean[]visited)
    {
        if(visited[idx])return false;
        visited[idx] = true;
        if(arr[idx] == 0)return true;
        
        if(idx+arr[idx]<arr.length && dfs(arr,idx+arr[idx],visited))return true;
        
        if(idx-arr[idx]>=0 && dfs(arr,idx-arr[idx],visited))return true;
        
        return false;
            
    }
}
