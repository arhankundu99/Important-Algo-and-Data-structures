// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        job[] job = new job[startTime.length];
        
        for(int i = 0; i < job.length; i++)job[i] = new job(startTime[i], endTime[i], profit[i]);
        
        //sorting the array wrt end times so that we can easily find the previous job which does not conflict with the current job
        Arrays.sort(job, new Comparator<job>(){
            public int compare(job a, job b){
                return a.endTime - b.endTime;
            }
        });
        
        int[] dp = new int[startTime.length];
        // dp[i] denotes the profit upto ith job
        // dp[dp.length-1] would be the ans
        
        dp[0] = job[0].profit;
        
        for(int i = 1; i < dp.length; i++){
            //two cases
            //we can either include the current job or not include the current job
            
            //including the current job
            int profit1 = job[i].profit;
            
            //now find the latest job which does not conflict with the previous job using binary search
            int idx = binarySearch(job, i);
            
            if(idx != -1)profit1 += dp[idx];
        
            //do not include the current profit
            int profit2 = dp[i-1];
            
            dp[i] = Math.max(profit1, profit2);
        }
        //for(int i = 0; i < dp.length; i++)System.out.println(dp[i]+" ");
        return dp[dp.length-1];
    }
    public int binarySearch(job[] jobs, int idx){
        int low = 0, high = idx-1;
        int ans = -1;    
        while(low <= high){
            int mid = (low + high) / 2;
    
            if(jobs[mid].endTime <= jobs[idx].startTime){
                ans = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return ans;
    }
}
class job{
    int startTime, endTime, profit;
    job(int s, int e, int p){
        startTime = s;
        endTime = e;
        profit = p;
    }
}