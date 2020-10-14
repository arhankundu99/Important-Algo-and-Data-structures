// https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1
class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int newindex = 0, max_sum; 
        Map<Integer, Integer> uniqueArr = new HashMap<>();

        TreeSet<Integer>set = new TreeSet<>();
        for(int i = 0; i < n; i++)set.add(arr[i]);
        for (int x: set) { 
            newindex++; 
            uniqueArr.put(x, newindex); 
        } 
  
        int[] BITree = new int[newindex + 1]; 
  
        for (int i = 0; i <= newindex; i++) { 
            BITree[i] = 0; 
        } 
  
        for (int i = 0; i < n; i++) { 
            max_sum = getSum(BITree, uniqueArr.get(arr[i]) - 1); 
            updateBIT(BITree, newindex, uniqueArr.get(arr[i]), max_sum + arr[i]); 
        } 
        return getSum(BITree, newindex); 
	}  
	int getSum(int[] BITree, int index) 
    { 
        int sum = 0; 
        while (index > 0) { 
            sum = Math.max(sum, BITree[index]); 
            index -= index & (-index); 
        } 
        return sum; 
    } 

    void updateBIT(int[] BITree, int newIndex, int index, int val) 
    { 
        while (index <= newIndex) { 
            BITree[index] = Math.max(val, BITree[index]); 
            index += index & (-index); 
        } 
    } 
}
