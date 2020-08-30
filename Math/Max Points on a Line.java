// https://leetcode.com/problems/max-points-on-a-line/
class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 0 || points.length == 1)return points.length;
        int ans = 0;
        
        for(int i = 1; i < points.length; i++){
            int duplicate = 0;
            int maxPoints = 0;
            Map<Integer, Map<Integer, Integer>>map = new HashMap<>();
            for(int j = 0; j < i; j++){
                int x2 = points[i][0];
                int y2 = points[i][1];
                
                int x1 = points[j][0];
                int y1 = points[j][1];
                
                int dX = x2 - x1;
                int dY = y2 - y1;
                
                int gcd = gcd(dX, dY);
                
                if(gcd == 0){
                    duplicate++;
                    continue;
                }
                
                dX /= gcd;
                dY /= gcd;
                
                if(!map.containsKey(dX)){
                    Map<Integer, Integer> map2 = new HashMap<>();
                    map2.put(dY, 1);
                    map.put(dX, map2);
                }
                else if(!map.get(dX).containsKey(dY))map.get(dX).put(dY, 1);
                else map.get(dX).put(dY, map.get(dX).get(dY)+1);
                
                maxPoints = Math.max(maxPoints, map.get(dX).get(dY));
            }
            maxPoints += duplicate + 1;
            ans = Math.max(ans, maxPoints);
        }
        return ans;
    }
    public int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b, a%b);
    }
}
