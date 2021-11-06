//https://leetcode.com/problems/single-number-iii/description/
//https://leetcode.com/problems/single-number-iii/discuss/1561785/Java-Simple-Bit-Manipulation-using-XOR-or-Two-Pass-or-Beats-100-0ms-or-TC:O(N)-SC:O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        
        for(int num: nums)xor ^= num;
        
        //twos complement of a is -a;
        
        int rightMostBit = xor & (-xor);
        
        int a = 0;
        
        for(int num: nums){
            if((num & rightMostBit) == 0)continue;
            a ^= num;
        }
        return new int[]{a, xor ^ a};
    }
}
