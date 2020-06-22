// leetcode 406. Queue Reconstruction by Height
// Difficulty: Medium


//Idea: Think where will you place the shortest person in the result array.
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b)
            {
                if(a[0] == b[0])return b[1]-a[1];
                return a[0]-b[0];
            }
        });
        
        int[][] ans = new int[people.length][2];
        
        for(int i=0;i<people.length;i++)Arrays.fill(ans[i], -1);
        
        for(int i=0;i<people.length;i++)
        {
            int pos = -1;
            for(int j=0;j<people.length;j++)
            {
                if(ans[j][0] == -1)pos++;
                if(pos == people[i][1])
                {
                    ans[j][0] = people[i][0];
                    ans[j][1] = people[i][1];
                    break;
                }
            } 
        }
        return ans;
    }
}
// Time complexity: O(N^2)

// Another Solution
// Idea: Pick out tallest group of people and sort them in a subarray (S). 
// Since there's no other groups of people taller than them, therefore each guy's index will be just as same as his k value.
// For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){return a[0] == b[0]?a[1] - b[1]: b[0] - a[0];}
        });
        List<int[]>list = new ArrayList<>();
        for(int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);
        
        int[][] ans = new int[people.length][2];
        int idx = 0;
        
        for(int[] curr: list)ans[idx++] = curr;
        return ans;
    }
}
// Time complexity: O(N^2) not O(NLOGN) because of adding elements in the list
