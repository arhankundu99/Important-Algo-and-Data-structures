// https://leetcode.com/problems/binary-trees-with-factors/description/?envType=daily-question&envId=2023-10-26

class Solution {
    private final int MOD = (int)(Math.pow(10, 9) + 7);
    public int numFactoredBinaryTrees(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for(int num: arr){
            set.add(num);
        }

        Map<Integer, Set<Integer>> factorMap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            if(!factorMap.containsKey(arr[i])){
                factorMap.put(arr[i], new HashSet<>());
            }
            for(int j = 0; j < arr.length; j++){
                if(arr[i] % arr[j] == 0 && set.contains(arr[i] / arr[j])){
                    factorMap.get(arr[i]).add(arr[j]);
                }
            }
        }

        Map<Integer, Integer> dp = new HashMap<>();
        return numFactoredBinaryTrees(arr, factorMap, -1, dp);

    }

    private int numFactoredBinaryTrees(int[] arr, Map<Integer, Set<Integer>> factorMap, int parent, Map<Integer, Integer> dp){
        
        if(dp.containsKey(parent)){
            return dp.get(parent);
        }
        if(parent == -1){
            long count = 0;

            for(int num: arr){
                count += numFactoredBinaryTrees(arr, factorMap, num, dp);
                count %= MOD;
            }

            return (int)count;
        }

        else{
            long count = 1;
            if(factorMap.containsKey(parent)){
                for(int factor: factorMap.get(parent)){
                    count += (1L * numFactoredBinaryTrees(arr, factorMap, factor, dp) * numFactoredBinaryTrees(arr, factorMap, parent / factor, dp));
                    count %= MOD;
                }
            }
            dp.put(parent, (int)count);
            return (int)count;
        }
    }

}