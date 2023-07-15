//https://leetcode.com/problems/single-number-iii/description/
//https://leetcode.com/problems/single-number-iii/discuss/1561785/Java-Simple-Bit-Manipulation-using-XOR-or-Two-Pass-or-Beats-100-0ms-or-TC:O(N)-SC:O(1)
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num: nums){
            xor ^= num;
        }

        int setBitPos = -1;
        // at this bit, these 2 numbers are different
        for(int i = 0; i < 32; i++){
            if((xor & (1 << i)) != 0){
                setBitPos = i;
                break;
            }
        }

        if(setBitPos == -1){
            return new int[]{-1, -1};
        }

        int lastSetBit = (1 << setBitPos);

        int p = 0, q = 0;
        for(int num: nums){
            if((num & lastSetBit) != 0){
                p ^= num;
            }
            else q ^= num;
        }

        return new int[]{p, q};
    }
}
