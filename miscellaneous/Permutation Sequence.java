// https://leetcode.com/problems/permutation-sequence/
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++)list.add(i);
        
        int[] fact = new int[n + 1];
        fact[0] = 1; fact[1] = 1;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i <= n; i++)fact[i] = i * fact[i - 1];
        
        k = k - 1;
        for(int i = 1; i <= n; i++){
            int idx = k / fact[n - i];

            
            sb.append(list.get(idx));
            list.remove(idx);
            k = k - idx*fact[n - i];
        }
        return sb.toString();
    }
}
