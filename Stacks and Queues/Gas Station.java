// leetcode problem no 134
//There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

//You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
//You begin the journey with an empty tank at one of the gas stations.

//Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx1=0,idx2=0;
        boolean[] vis = new boolean[gas.length];
        int currGas=0;
        
        while(idx1 < gas.length)
        {
            currGas += gas[idx2] - cost[idx2];
            
            if(currGas < 0)
            {
                idx1 = (idx2+1) % gas.length;
                if(vis[idx1])return -1;
                vis[idx1] = true;
                currGas = 0;
            }
            else 
            {
                if((idx2 + 1) % gas.length == idx1) return idx1;
            }
            idx2 = (idx2 + 1) % gas.length; 
        }
        return -1;
        
    }
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, tank = 0, sumGas = 0, sumCost = 0;
        
        //if totalGas > totalCost, then a solution will exist
        //else return -1
        
        for(int i = 0; i < gas.length; i++){
            sumGas += gas[i];
            sumCost += cost[i];
            
            tank += gas[i] - cost[i];
            
            if(tank < 0){
                start = (i + 1);
                tank = 0;
            }
        }
        
        if(sumGas < sumCost)return -1;
        return start;
    }
}
