// https://leetcode.com/contest/biweekly-contest-34/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while(left + 1 < arr.length && arr[left] <= arr[left+1]) left++;
        if(left == arr.length - 1) return 0;
        
        int right = arr.length - 1;
        while(right > left && arr[right-1] <= arr[right]) right--;
        int result = Math.min(arr.length - left - 1, right);
        
        int i = 0;
        int j = right;
        while(i <= left && j < arr.length) {
            if(arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            }else {
                j++;
            }   
        }
        return result;
    }
}

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while(left < arr.length-1 && arr[left] <= arr[left+1])left++;
        if(left == arr.length-1)return 0;        
        int right = arr.length-1;
        while(right >= 1 && arr[right] >= arr[right-1])right--;

        int length = 0;
        
        for(int i = left; i >= 0; i--){
            int idx = binarySearch(arr, right, arr.length-1, arr[i]);
            if(idx == -1)length = Math.max(length, i+1);
            else length = Math.max(length, i+1+arr.length-idx);
        }
        for(int i = right; i < arr.length; i++){
            int idx = binarySearch2(arr, 0, left, arr[i]);
            if(idx == -1)length = Math.max(length, arr.length-i);
            else length = Math.max(length, idx+1+arr.length-i);
        }
        return arr.length-length;
    }
    public int binarySearch(int[] arr, int low, int high, int val){
        int idx = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] >= val){
                idx = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return idx;
    }
    public int binarySearch2(int[] arr, int low, int high, int val){
        int idx = -1;
        while(low <= high){
            int mid = (low + high)/2;
            if(arr[mid] <= val){
                idx = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return idx;
    }
}
