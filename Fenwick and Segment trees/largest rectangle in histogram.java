class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)return 0;
        
        segmentTree st = new segmentTree(heights.length);
        
        st.build(0, 0, heights.length-1, heights);
        
        return solve(st, heights, 0, heights.length-1);        
    }
    public int solve(segmentTree st, int[] heights, int l, int r){
        pair pair = st.getMin(0, 0, heights.length-1, l, r);

        int min = pair.val;
        int minIdx = pair.idx;
        
        
        if(minIdx == Integer.MAX_VALUE)return Integer.MIN_VALUE;
        
        int area1 = min * (r-l+1);
        
        int area2 = Integer.MIN_VALUE, area3 = Integer.MIN_VALUE;
        
        if(minIdx - 1 >= l)area2 = solve(st, heights, l, minIdx-1);
        if(r >= minIdx+1)area3 = solve(st, heights, minIdx+1, r);
        
        
        return Math.max(area1, Math.max(area2, area3));
        
    }
}
class segmentTree{
    pair[] tree;
    
    segmentTree(int n){
        tree = new pair[4*n];
    }
    
    void build(int node, int l, int r, int[] a){
        if(l == r){
            tree[node] = new pair(a[l], l);
            return;
        }
        int mid = (l+r)/2;
        build(2*node+1, l, mid, a);
        build(2*node+2, mid+1, r, a);
        
        if(tree[2*node+1].val < tree[2*node+2].val)tree[node] = tree[2*node+1];
        else tree[node] = tree[2*node+2];
    }
    pair getMin(int node, int l, int r, int left, int right){
        
        if(right < l || left > r)return new pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        if(l >= left && r <= right)return tree[node];
        int mid = (l+r)/2;
        
        pair pair1 = getMin(2*node+1, l, mid, left, right);
        pair pair2 = getMin(2*node+2, mid+1, r, left, right);
        
        if(pair1.val == pair2.val)return pair1.idx < pair2.idx? pair1: pair2;
        if(pair1.val < pair2.val)return pair1;
        return pair2;
    }
}
class pair{
    int val, idx;
    pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}
