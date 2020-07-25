// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

class Solution {
    public int findMin(int[] a) {
        if(a.length == 1)return a[0];
        int low = 0;
        int high = a.length-1;
        
        while(low < high){
            int mid = (low+high)/2;
            if(a[mid] > a[high])low = mid+1;
            else high = mid;
        }
        return a[low];
    }
}
