// Problem number 69
// Implement square root
// Idea- Use binary Search


class Solution {
    public int mySqrt(int x) {
        if(x == 0||x == 1)return x;
        return binarySearch(0,x,x);
    }
    public int binarySearch(int left,int right,int x)
    {
        while(left <= right)
        {
            int mid = (left + right)/2;
            if(mid <= x/mid && (mid+1) > x/(mid+1))return mid;
            // we are checking mid <= x/mid instead of mid*mid <= x to avoid overflow
            
            if(mid > x/mid)high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
}
