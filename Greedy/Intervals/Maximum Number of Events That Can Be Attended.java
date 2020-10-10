//Approach 1: greedy (TLE)
//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[1] - b[1];
            }
        });
        
        Set<Integer> set = new HashSet<>();
        int max = 0, min = Integer.MAX_VALUE;
        for(int[] event: events){
            max = Math.max(max, event[1]);
            min = Math.min(min, event[0]);
        }
        for(int i = min; i <= max; i++)set.add(i);
        
        int count = 0;
        
        for(int[] event: events){
            int start = event[0];
            int end = event[1];
            
            for(int i = start; i <= end; i++){
                if(set.contains(i)){
                    count++;
                    set.remove(i);
                    break;
                }
            }
        }
        return count;
    }
}
//Approach 2
public int maxEvents(int[][] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.sort(A, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, d = 0, n = A.length;
        while (!pq.isEmpty() || i < n) {
            if (pq.isEmpty())
                d = A[i][0];
            while (i < n && A[i][0] <= d)
                pq.offer(A[i++][1]);
            pq.poll();
            ++res; ++d;
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
        }
        return res;
    }
