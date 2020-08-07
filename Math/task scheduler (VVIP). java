// https://leetcode.com/problems/task-scheduler/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tasks.length; i++){
            if(!map.containsKey(tasks[i]))map.put(tasks[i], 1);
            else map.put(tasks[i], map.get(tasks[i])+1);
        }
        int max = 0, p = 0;
        for(char key: map.keySet()){
            max = Math.max(max, map.get(key));
        }
        for(char key: map.keySet()){
            if(map.get(key) == max)p++;
        }
        return Math.max((max - 1)*(n + 1) + p, tasks.length);
    }
}
