// https://practice.geeksforgeeks.org/contest-problem/most-efficient-way-to-reach-end-of-array/1/
class Minimum
{
    public int min_cost(int[] arr , int n)
    {
        return d(arr);
    }
    public int d(int[] arr){
        int[] dist = new int[arr.length];
        int[] parent = new int[arr.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        
        PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.dist - b.dist;
            }   
        });
        
        queue.add(new pair(0, 0));
        
        while(queue.size() != 0){
            pair u = queue.poll();
            
            int idx = u.idx;
            
            if(idx + 3 < arr.length){
                if(dist[idx + 3] > dist[idx] + arr[idx]){
                    dist[idx + 3] = dist[idx] + arr[idx];
                    parent[idx + 3] = idx;
                    queue.add(new pair(idx + 3, dist[idx + 3]));
                }
            }
            
            if(idx - 1 >= 0){
                if(dist[idx - 1] > dist[idx] + arr[idx]){
                    dist[idx - 1] = dist[idx] + arr[idx];
                    parent[idx-1] = idx;
                    queue.add(new pair(idx - 1, dist[idx - 1]));
                }
            }
        }
        int sum = 0;
        int idx = arr.length-1;
        while(idx != 0){
            sum += arr[idx];
            idx = parent[idx];
        }
        return sum + arr[0];
    }
}
class pair{
    int idx, dist;
    pair(int idx, int dist){
        this.idx = idx;
        this.dist = dist;
    }
}
