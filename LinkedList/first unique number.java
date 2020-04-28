/*
You have a queue of integers, you need to retrieve the first unique integer in the queue.

Implement the FirstUnique class:

FirstUnique(int[] nums) Initializes the object with the numbers in the queue.
int showFirstUnique() returns the value of the first unique integer of the queue, and returns -1 if there is no such integer.
void add(int value) insert value to the queue.
*/

/*linkedHashMap is like hashmap but it preserves the order of insertion*/

class FirstUnique {
    
    Set<Integer>set;
    Map<Integer,Integer>map;
    public FirstUnique(int[] nums) {
        set = new LinkedHashSet<>();
        map = new HashMap<>();
        for(int i:nums)add(i);
    }
    
    public int showFirstUnique() {
        for(int x: set)return x;
        return -1;
    }
    
    public void add(int value) {
        if(map.containsKey(value))set.remove(value);
        else set.add(value);
        map.put(value, 1+map.getOrDefault(value,0));
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
