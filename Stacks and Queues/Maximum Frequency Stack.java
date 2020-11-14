// https://leetcode.com/problems/maximum-frequency-stack/
class FreqStack {
    Map<Integer, Integer>map;
    Map<Integer, Stack<Integer>>group;
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        if(!map.containsKey(x))map.put(x, 1);
        else map.put(x, map.get(x) + 1);
        maxFreq = Math.max(maxFreq, map.get(x));
        
        if(!group.containsKey(map.get(x)))group.put(map.get(x), new Stack<>());
        group.get(map.get(x)).push(x);
    }
    
    public int pop() {
        int pop = group.get(maxFreq).pop();
        map.put(pop, map.get(pop) - 1);
        if(map.get(pop) == 0)map.remove(pop);
        if(group.get(maxFreq).size() == 0){
            group.remove(maxFreq);
            maxFreq--;
        }
        return pop;
    }
}
