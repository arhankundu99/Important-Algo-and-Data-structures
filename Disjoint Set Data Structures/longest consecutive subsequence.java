// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge-2021/603/week-1-june-1st-june-7th/3769
//O(n) solution using Set:

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)set.add(nums[i]);
               
        int max = 0; //stores the max length of consecutive numbers
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i] - 1))continue;    //we should not start from this number
			
            int curr = nums[i]; // start from this number
			int currL = 1; //current length of the sequence
         
            while(set.contains(curr + 1)){
                currL += 1;
                curr = curr + 1;
            }
            max = Math.max(max, currL);
        }
        return max;
    }
}

//Using Union-Find:

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)return 0;
        dsu dsu = new dsu(nums.length);
        Map<Integer, Integer> map = new HashMap<>();

        
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]))continue;
            
            if(map.containsKey(nums[i] - 1))dsu.union(i, map.get(nums[i] - 1));
            if(map.containsKey(nums[i] + 1))dsu.union(i, map.get(nums[i] + 1));            
            
            map.put(nums[i], i);
        }
        
        return dsu.maxSize;
    }
}
class dsu{
    int[] parent;
    int[] size;
    int maxSize;
    dsu(int n){
        parent = new int[n];
        size = new int[n];
        
        for(int i = 0; i < n; i++)parent[i] = i;
        for(int i = 0; i < n; i++)size[i] = 1;
        maxSize = 1;
    }
    
    void union(int u, int v){
        u = find(u);
        v = find(v);
        if(u == v)return;
        if(size[u] >= size[v]){
            parent[v] = u;
            size[u] += size[v];
            maxSize = Math.max(maxSize, size[u]);
        }
        else{
            parent[u] = v;
            size[v] += size[u];
            maxSize = Math.max(maxSize, size[v]);
        }
    }
    
    int find(int x){
        if(x == parent[x])return x;
        return find(parent[x]);
    }
}
