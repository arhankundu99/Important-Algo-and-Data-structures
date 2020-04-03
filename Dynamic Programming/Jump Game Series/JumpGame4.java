//problem no 1345

/*
Given an array of integers arr, you are initially positioned at the first index of the array.
In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.
*/

class Solution {
    public int minJumps(int[] arr) {
        
        if(arr.length<=1)return 0;
        if(arr[0]==arr[arr.length-1])return 1;
        if(arr[0]==arr[arr.length-2])return 2;
        
        Map<Integer, ArrayList<Integer>>map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++)
        {
            if(!map.containsKey(arr[i]))map.put(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        int[]dist = new int[arr.length];
        boolean[]visited = new boolean[arr.length];
        
        bfs(map,0,dist,visited,arr);
        
        //for(int i=0;i<arr.length;i++)System.out.print(dist[i]+" ");
        return dist[arr.length-1];
    }
    public void bfs(Map<Integer, ArrayList<Integer>>map, int idx, int[]dist, boolean[]visited, int[]arr)
    {
        Queue<Integer>queue = new LinkedList<>();
        queue.add(idx);
        visited[idx] = true;
        while(queue.size()!=0)
        {
            int u = queue.poll();
            for(int i=0;i<map.get(arr[u]).size();i++)
            {
                int v = map.get(arr[u]).get(i);
                if(visited[v])continue;
                visited[v]=true;
                dist[v]=dist[u]+1;
                if(v==dist.length-1)return;
                queue.add(v);
                
            }
            if(u+1<arr.length&&!visited[u+1])
            {
                queue.add(u+1);
                visited[u+1]=true;
                dist[u+1]=dist[u]+1;
                if(u+1==dist.length-1)return;
                
            }
            if(u-1>=0&&!visited[u-1])
            {
                queue.add(u-1);
                visited[u-1]=true;
                dist[u-1]=dist[u]+1;
            }
            
        }
    }
}
