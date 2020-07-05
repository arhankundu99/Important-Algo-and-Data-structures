//Difficulty: Hard
//leetcode problem: 1434
//https://leetcode.com/problems/number-of-ways-to-wear-different-hats-to-each-other/

//When to use bitmasks: whenever you see a problem of assigning objects or things to people, try to use bitmask
//Time Complexity: O((2^N) * M * (N)) where M is the number of different hats, N is the number of people

class Solution {
    int M = 1000000007;
    int [][]dp;
    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();
        
        //dp[i][j] represents the count when mask is i and hat number is j
        dp = new int[1025][41];
        
        for(int i = 0; i < 1025; i++)Arrays.fill(dp[i], -1);
        
        //list[i] would denote the list of persons who have ith hat 
        ArrayList<Integer>[] list = new ArrayList[41];
        for(int i = 0; i < 41; i++)list[i] = new ArrayList<>();
        
        for(int i = 0; i < hats.size(); i++){
            for(int hat: hats.get(i))list[hat].add(i);
        }
        // solve function has 4 parameters: mask, hat number, list and number of persons
        // solve function returns the number of ways of assigning hats from hat number starting from 1 to 40
        // initially mask is 0 since we have not assigned hats to any person
        return solve(0, 1, list, n);
    }
    public int solve(int mask, int hat, ArrayList<Integer>[]list, int n){
        
        //if(mask == 1111....n times)then we have assigned hats to every person. so return 1 in this case;
        if(mask == ((1 << n) - 1))return 1;
        
        if(hat == 41)return 0;
        
        if(dp[mask][hat] != -1)return dp[mask][hat];
        
        //given a hat, we have 2 choices: Either assign it or do not assign the hat to any person
        
        //do not assign the hat to any person
        long count = solve(mask, hat+1, list, n) % M;
        
        //assign the hat
        for(int i = 0; i < list[hat].size(); i++){
            int person = list[hat].get(i);
            
            //if the person is already wearing a hat, then we can't assign him any hat
            if((mask & (1 << person)) != 0)continue;
            
            //The person is not wearing a hat. So change the person's status in the mask 
            count += solve(mask | (1 << person), hat+1, list, n);
            
            count %= M;
        }
        dp[mask][hat] = (int)count;
        return (int)count;
    }
}
