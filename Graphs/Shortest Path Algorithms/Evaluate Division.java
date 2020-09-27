// https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3474/
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        Set<String> eq = new HashSet<>();
        
        for(int i = 0; i < equations.size(); i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            
            if(!map.containsKey(s1))map.put(s1, new HashMap<>());
            if(!map.containsKey(s2))map.put(s2, new HashMap<>());
            
            map.get(s1).put(s2, values[i]);
            map.get(s2).put(s1, 1/values[i]);
            
            map.get(s1).put(s1, 1D);
            map.get(s2).put(s2, 1D);
            
            eq.add(s1);
            eq.add(s2);
        }
    
        for(String k: eq){
            for(String i: eq){
                for(String j: eq){
                    
                    if(!map.get(i).containsKey(k))continue;
                    if(!map.get(k).containsKey(j))continue;
                    
                    
                    double dist1 = map.get(i).get(k);
                    double dist2 = map.get(k).get(j);
                    double dist3 = map.get(i).containsKey(j)? map.get(i).get(j): 100000;
                    
                    
                    if(dist3 > dist1 * dist2)map.get(i).put(j, dist1 * dist2);
                    
                }
            }
        }
        double[] ans = new double[queries.size()];
        int idx = 0;
        for(List<String> q: queries){
            String s1 = q.get(0);
            String s2 = q.get(1);
            
            if(map.containsKey(s1) && map.get(s1).containsKey(s2))ans[idx++] = map.get(s1).get(s2);
            else ans[idx++] = -1;
        }
        return ans;
    }
}
