// https://leetcode.com/problems/sequential-digits/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] allNums = {12,23,34,45,56,67,78,89,
                         123,234,345,456,567,678,789,
                         1234,2345,3456,4567,5678,6789,
                         12345,23456,34567,45678,56789,
                         123456,234567,345678,456789,
                         1234567,2345678,3456789,
                         12345678,23456789,
                         123456789};
        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int i = 0; i < n; i++) {
            if (allNums[i] < low) continue;
            if (allNums[i] > high) break;
            res.add(allNums[i]);
        }
        return res;
    }
}

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        if(low <= 0 && high >= 0) ans.add(0);
        for(int i = 1; i < 10; i++) q.add(i);
        while(q.size() > 0){
            int curr = q.remove();
            if(curr >= low && curr <= high) ans.add(curr);
            int onesDigit = curr % 10;
            if(onesDigit < 9 && curr * 10 + onesDigit + 1 <= high) q.add(curr * 10 + onesDigit + 1);
        }
        return ans;
    }
}
