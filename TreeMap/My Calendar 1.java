// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/604/week-2-june-8th-june-14th/3774/
class MyCalendar {
    TreeMap<Integer, Integer> line;
    public MyCalendar() {
        line = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer previous = line.floorKey(start);
        Integer next = line.ceilingKey(start);

        if (previous != null && start < line.get(previous)) {
            return false;
        }

        if (next != null && end > next) {
            return false;
        }

        line.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
