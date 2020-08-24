// https://leetcode.com/problems/task-scheduler/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        for(int i = 0; i < tasks.length; i++)freq[tasks[i] - 65]++;
        
        Arrays.sort(freq);
        
        int max = freq[25];
        
        int p = 1;
        
        for(int i = 24; i >= 0; i--)if(freq[i] == max)p++;
        
        return Math.max((max-1)*(n+1) + p, tasks.length);
    }
}
