// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3472/

class Solution {
    public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++)arr[i] = nums[i];
        
        Arrays.sort(arr, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                String s1 = String.valueOf(a) + String.valueOf(b);
                String s2 = String.valueOf(b) + String.valueOf(a);
                
                return s2.compareTo(s1);
            }
        });
        String ans = "";
        for(Integer x: arr){
            if(x == 0 && ans.length() == 0)continue;
            ans += String.valueOf(x);
        }
        return ans.length() == 0?"0":ans;
    }
}
