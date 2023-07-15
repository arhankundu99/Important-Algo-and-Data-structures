// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/
class Solution {
    public int maxValue(int[][] events, int k) {
        
        // sort the events based on events end day
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] event1, int[] event2){
                return event1[1] - event2[1];
            }
        });

        int[][] dp = new int[events.length][k + 1];
        
        dp[0][1] = events[0][2];

        for(int i = 0; i < events.length; i++){
            dp[i][0] = 0;
        }
        //[1, 2, 4], [2, 3, 1]
        for(int i = 1; i < events.length; i++){
            int[] event = events[i];

            // consider this event, find the latest event that does not collide with this event
            int latestEventIdx = binarySearch(events, i);

            if(latestEventIdx != -1){
                for(int j = 0; j <= i && j < k; j++){
                    dp[i][j + 1] = event[2] + dp[latestEventIdx][j];
                }
            }
            else{
                dp[i][1] = event[2];
            }

            for(int j = 0; j <= i && j <= k; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        int maxProfit = 0;
        for(int i = 0; i <= k; i++){
            maxProfit = Math.max(maxProfit, dp[events.length - 1][i]);
        }

        return maxProfit;
    }

    public int binarySearch(int[][] events, int idx){
        int low = 0, high = idx - 1;
        int ans = -1;    
        while(low <= high){
            int mid = (low + high) / 2;
    
            if(events[mid][1] < events[idx][0]){
                ans = mid;
                low = mid + 1;
            }
            else high = mid-1;
        }
        return ans;
    }    

    private void printArr(int[][] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}