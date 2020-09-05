// https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/553/week-5-august-29th-august-31st/3442/

class dsu{
    int[] parent;
    int[] size;
    int max;
    dsu(int n){
        parent = new int[n];
        size = new int[n];
        max = 1;
        
        for(int i = 0; i < n; i++)parent[i] = i;
        for(int i = 0; i < n; i++)size[i] = 1;
    }
    int find(int x){
        if(x == parent[x])return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        int x_rep = find(x);
        int y_rep = find(y);
        
        if(x_rep == y_rep)return;
        
        if(size[x_rep] > size[y_rep]){
            parent[y_rep] = x_rep;
            size[x_rep] += size[y_rep];
            max = Math.max(max, size[x_rep]);
        }
        else{
            parent[x_rep] = y_rep;
            size[y_rep] += size[x_rep];
            max = Math.max(max, size[y_rep]);
        }
    }
}
class Solution {
    public int largestComponentSize(int[] A) {
        dsu dsu = new dsu(A.length);
        
        Map<Integer, Integer>map = new HashMap<>();
        
        for(int i = 0; i < A.length; i++){
            for(int j = 2; j*j <= A[i]; j++){
                if(A[i] % j == 0){
                    if(!map.containsKey(j)){
                        map.put(j, i);
                    }
                    else dsu.union(i, map.get(j));
                    
                    if(!map.containsKey(A[i]/j)){
                        map.put(A[i]/j, i);
                    }
                    else dsu.union(i, map.get(A[i]/j));
                }
            }
            if(A[i] > 1){
                if(!map.containsKey(A[i]))map.put(A[i], i);
                else dsu.union(i, map.get(A[i]));
            }
        }
        return dsu.max;
    }
}
