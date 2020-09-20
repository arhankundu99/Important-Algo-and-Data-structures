// https://leetcode.com/problems/sequential-digits/
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer>list = new ArrayList<>();
        
        for(int i = 1; i <= 9; i++)queue.add(i);
        
        while(queue.size() != 0){
            int poll = queue.poll();
            if(poll > high)break;
            if(poll >= low && poll <= high)list.add(poll);
            
            int lastDigit = poll % 10;
            
            if(lastDigit != 9)queue.add(poll*10 + lastDigit+1);
        }
        return list;
    }
}
