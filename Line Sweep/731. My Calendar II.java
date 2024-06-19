// https://leetcode.com/problems/my-calendar-ii/description/
class MyCalendarTwo {
    TreeMap<Integer, Integer> calendarMap;
    public MyCalendarTwo() {
        calendarMap = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        calendarMap.put(start, calendarMap.getOrDefault(start, 0) + 1);
        calendarMap.put(end, calendarMap.getOrDefault(end, 0) - 1);

        int count = 0;

        for (int key: calendarMap.keySet()) {
            count += calendarMap.get(key);
            if (count >= 3) {
                calendarMap.put(start, calendarMap.getOrDefault(start, 0) - 1);
                calendarMap.put(end, calendarMap.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */