// https://leetcode.com/problems/smallest-string-with-swaps/
class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        dsu dsu = new dsu(s.length());
        char[] s_array = s.toCharArray();
        
        for(List<Integer> pair: pairs){
            dsu.union(pair.get(0), pair.get(1));
        }
        
        
        Map<Integer, List<Integer>>map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int find = dsu.find(i);
            if(!map.containsKey(find))map.put(find, new ArrayList<>());
            map.get(find).add(i);
        }
        
        
        for(int key: map.keySet()){
            char[] c = new char[map.get(key).size()];
            Collections.sort(map.get(key));
            int idx = 0;
            for(int i: map.get(key))c[idx++] = s.charAt(i);
            
            Arrays.sort(c);
            
            idx = 0;
            for(int i: map.get(key))s_array[i] = c[idx++];
        }
        return String.valueOf(s_array);
    }
}
class dsu{
    int[] parent;
    int[] rank;
    dsu(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)parent[i] = i;
    }
    int find(int x){
        if(parent[x] == x)return x;
        return parent[x] = find(parent[x]);
    }
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y)return;
        if(rank[x] > rank[y]){
            parent[y] = x;
        }
        else if(rank[y] > rank[x]){
            parent[x] = y;
        }
        else{
            parent[x] = y;
            rank[y]++;
        }
    }
}
