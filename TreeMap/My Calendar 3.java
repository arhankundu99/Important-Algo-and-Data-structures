// https://leetcode.com/problems/my-calendar-iii/submissions/817100892/
class MyCalendarThree {

    private TreeMap<Integer, Integer> treeMap;
    public MyCalendarThree() {
        treeMap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        treeMap.put(start, treeMap.getOrDefault(start, 0) + 1);
        treeMap.put(end, treeMap.getOrDefault(end, 0) - 1);

        int intersectionCount = 0, sum = 0;
        for(int key: treeMap.keySet()){
            sum += treeMap.get(key);
            intersectionCount = Math.max(intersectionCount, sum);
        }
        return intersectionCount;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
