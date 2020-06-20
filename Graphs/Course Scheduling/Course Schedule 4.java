// leetcode 1462. Course Schedule IV
// problem link: https://leetcode.com/problems/course-schedule-iv/

class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] pre, int[][] queries) {
        boolean[][] graph = new boolean[n][n];
        
        for(int i=0;i<pre.length;i++)graph[pre[i][0]][pre[i][1]] = true;
        
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    graph[i][j] = graph[i][j] || (graph[i][k] && graph[k][j]);
        
        List<Boolean>list = new ArrayList<>();
        
        for(int i=0;i<queries.length;i++)
            list.add(graph[queries[i][0]][queries[i][1]]);
        
        return list;
    }
}
