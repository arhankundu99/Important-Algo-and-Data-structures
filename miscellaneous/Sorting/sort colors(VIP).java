class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0, p2 = nums.length-1, idx = 0;
        
        while(idx <= p2){
            if(nums[idx] == 0){
                swap(nums, p0, idx);
                p0++;
                idx++;
            }
            else if(nums[idx] == 2){
                swap(nums, p2, idx);
                p2--;
                //we are not increasing idx because now nums[idx] can be a one or zero
            }
            else idx++;
        }
    }
    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
