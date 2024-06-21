// "https://leetcode.com/problems/find-in-mountain-array/"

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int len = arr.length();
        int peakPt = getPeakPt(arr, len);
        int left = searchLeft(arr, target, 0, peakPt);
        if (left != -1) return left;
        return searchRight(arr, target, peakPt, len - 1);
    }
    private int searchRight(MountainArray arr, int target, int l, int h) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int curNum = arr.get(mid);
            if (curNum == target) return mid;
            else if (curNum < target) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
    private int searchLeft(MountainArray arr, int target, int l, int h) {
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int curNum = arr.get(mid);
            if (curNum == target) return mid;
            else if (curNum < target) l = mid + 1;
            else h = mid - 1;
        }
        return -1;
    }
    private int getPeakPt(MountainArray arr, int len) {
        int l = 0, h = len - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (arr.get(mid) < arr.get(mid + 1))
                l = mid + 1;
            else h = mid - 1;
        }
        return l;
    }
}
// Step1: Find the peak Index in MountainArray. Refer: LeetCode 852. Peak Index in a mountain array "https://leetcode.com/problems/peak-index-in-a-mountain-array/".
// Step2: Do a BS of the left part of the array i.e. 0->peakInd.
// Step3: If target already not found? Do another BS on the right part of the array i.e. peakInd -> len.