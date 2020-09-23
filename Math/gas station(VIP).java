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
