// https://www.geeksforgeeks.org/problems/intersecting-intervals/1
class Solution {
    public static int overlap(int n, int[][] intervals) {
        int ans = 0;
    	int count = 0;
    	List<Pair> line = new ArrayList<>();
     
    	// Store the x and y coordinates in vector line
    	for(int i = 0; i < intervals.length; i++){
        	line.add(new Pair(intervals[i][0], 'x'));
        	line.add(new Pair(intervals[i][1], 'y'));
    	}
     
    	// Sort the ranges
    	Collections.sort(line, (a, b) -> a.first - b.first == 0? a.second - b.second: a.first - b.first);
   
    	// Iterate the line vector for counting the number of overlaps
    	for(int i = 0; i < line.size(); i++){
         
        	// If element is equal to x it means new range is added
        	if (line.get(i).second == 'x')
           		count++;
   
        	// If element is equal to x it means a range is ended
        	if (line.get(i).second == 'y')
            	count--;
   
        	ans = Math.max(ans, count);
    	}
    	return ans;
    }
}

class Pair {
    int first;
    char second;
    
    Pair(int first, char second) {
        this.first = first;
        this.second = second;
    }
}
        
