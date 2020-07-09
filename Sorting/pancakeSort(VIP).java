//https://leetcode.com/problems/pancake-sorting/
//whenever you encounter a sorting problem like this one, think how to get the largest number in the correct place. O(N^2) solution will generally get accepted
class Solution {
    public List<Integer> pancakeSort(int[] A) {
        int lastIdx = A.length-1;
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i < A.length; i++){
            int idx = findLargestNumberIdx(A, lastIdx);
            flip(A, idx+1);
            flip(A, lastIdx+1);
            list.add(idx+1);
            list.add(lastIdx+1);
            lastIdx--;
        }
        return list;
    }
    public int findLargestNumberIdx(int[]A, int idx){
        for(int i = 0; i < A.length; i++){
            if(A[i] == idx+1)return i;
        }
        return -1;
    }
    
    public void flip(int[]A, int k){
        int idx1 = 0;
        int idx2 = k-1;
        
        while(idx1 < idx2){
            int temp = A[idx1];
            A[idx1] = A[idx2];
            A[idx2] = temp;
            
            idx1++;
            idx2--;
        }
    }
}
