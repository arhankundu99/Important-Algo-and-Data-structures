class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 0 || points.length == 1)return points.length;
        int ans = 0;
        
        for(int i = 1; i < points.length; i++){
            int duplicate = 0;
            int maxPoints = 0;
            Map<pair, Integer>map = new HashMap<>();
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
                
                pair pair = new pair(dX, dY);
                if(map.containsKey(pair))map.put(pair, map.get(pair)+1);
                else map.put(pair, 1);
                
                maxPoints = Math.max(maxPoints, map.get(pair));
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
class pair{
    int x, y;
    pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode(){
        return x*31+y;
    }
    @Override
    public boolean equals(Object o){
        pair pair = (pair)o;
        return ((this.x == pair.x) && (this.y == pair.y));
    }
}
