//https://leetcode.com/problems/permutations/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        generatePermutations(0, ans, new ArrayList<>(), nums);
        return ans;
    }
    public void generatePermutations(int mask, List<List<Integer>>ans, List<Integer>list, int[] nums){
        if(mask == (1<<nums.length)-1)
        {
            ans.add(new ArrayList(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if((mask & (1<<i)) == 0){
                list.add(nums[i]);
                generatePermutations(mask | 1<<i, ans, list, nums);
                list.remove(list.size()-1);
            }
        }
    }
}
