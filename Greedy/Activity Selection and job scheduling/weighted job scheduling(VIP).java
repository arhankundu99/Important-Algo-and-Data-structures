// https://leetcode.com/problems/maximum-profit-in-job-scheduling/
// O(n^2) solution (can give tle) try O(nlogn) solution

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        pair[] pair = new pair[startTime.length];
        
        for(int i = 0; i < pair.length; i++){
            pair[i] = new pair(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(pair, new Comparator<pair>(){
            public int compare(pair a, pair b){
                if(a.startTime == b.startTime)return a.endTime-b.endTime;
                return a.startTime-b.startTime;
            }
        });
        
        int[] dp = new int[pair.length];
        Arrays.fill(dp, -1);
        return helper(pair, 0, dp);
    }
    public int helper(pair[] pair, int idx, int[] dp){
        if(idx == pair.length)return 0;
        if(dp[idx] != -1)return dp[idx];
        int case1 = pair[idx].profit;
        int idx2 = idx+1;
        while(idx2 < pair.length){
            if(pair[idx2].startTime >= pair[idx].endTime)break;
            idx2++;
        }
        case1 += helper(pair, idx2, dp);
        int case2 = helper(pair, idx+1, dp);
        
        dp[idx] = Math.max(case1, case2);
        return dp[idx];
    }
}
class pair{
    int startTime, endTime, profit;
    pair(int startTime, int endTime, int profit){
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}

//O(nlogn) solution
// https://www.geeksforgeeks.org/weighted-job-scheduling-log-n-time/
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[] dp = new int[profit.length];
        //dp[i] would store the profit till ith job
        
        pair[] pair = new pair[profit.length];
        
        for(int i = 0; i < pair.length; i++)pair[i] = new pair(startTime[i], endTime[i], profit[i]);
        
        //now sort the pair array wrt finish times
        Arrays.sort(pair, new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.finishTime - b.finishTime;
            }
        });
        
        dp[0] = pair[0].profit;
        
        for(int i = 1; i < profit.length; i++){
            //now we have 2 choices
            //we can either include ith job or not include ith job
            
            //including ith job
            int including_ith_job_profit = pair[i].profit;
            // now do a binary search to find latest job that does not conflict with the ith job
            int idx = binarySearch(pair, i);
            
            if(idx != -1)including_ith_job_profit += dp[idx];
            
            dp[i] = Math.max(dp[i-1], including_ith_job_profit);
        }
        return dp[profit.length-1];
    }
    public int binarySearch(pair[] pair, int idx){
        int low = 0, high = idx-1;
        while(low <= high){
            int mid = (low+high)/2;
            
            if(pair[mid].finishTime <= pair[idx].startTime){
                if(pair[mid+1].finishTime <= pair[idx].startTime)low = mid+1;
                else return mid;
            }
            else high = mid-1;
        }
        return -1;
    }
}
class pair{
    int startTime, finishTime, profit;
    pair(int s, int f, int p){
        startTime = s;
        finishTime = f;
        profit = p;
    }
}
