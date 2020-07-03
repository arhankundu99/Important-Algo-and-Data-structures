//link: https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
//Difficulty: Medium

class Islands
{
    
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
    {
       boolean[][]vis = new boolean[N][M];
       int count = 0;
       for(int i = 0; i < list.size(); i++){
           for(int j = 0; j < list.get(i).size(); j++){
               if(!vis[i][j] && list.get(i).get(j) == 1){
                   count++;
                   dfs(i, j, list, vis);
               }
           }
       }
       return count;
    }
    static void dfs(int r, int c, ArrayList<ArrayList<Integer>> list, boolean[][]vis){
        if(r<0 || r==list.size() || c<0 || c==list.get(0).size() || list.get(r).get(c) != 1)return;
        if(vis[r][c])return;
        vis[r][c] = true;
        int[][]moves = {{1,0}, {-1,0}, {0,1}, {0,-1}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        
        for(int[]move: moves){
            dfs(r+move[0], c+move[1], list, vis);
        }
    }
}
