// https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<ArrayList<Integer>>res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int p1=i+1;
            int p2=nums.length-1;
            while(p1<p2)
            {
                if(nums[p1]+nums[p2]==-nums[i])
                {
                    ArrayList<Integer>aux=new ArrayList<>();
                    aux.add(nums[i]);
                    aux.add(nums[p1]);
                    aux.add(nums[p2]);
                    
                    res.add(aux);
                    p1++;
                    p2--;
                   
                }
                else if(nums[p1]+nums[p2]<-nums[i])p1++;
                else p2--;
                
            }
        }
       
        return new ArrayList(res);
    }
}
