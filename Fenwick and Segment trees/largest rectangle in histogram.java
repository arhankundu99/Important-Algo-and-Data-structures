//https://leetcode.com/problems/largest-rectangle-in-histogram/
class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights.length == 0)return 0;
        segmentTree st = new segmentTree(heights.length);
        st.build(0, 0, heights.length-1, heights);
        
        return solve(heights, st, 0, heights.length-1);
    }
    public int solve(int[] heights, segmentTree st, int l, int r){
        if(l > r)return Integer.MIN_VALUE;
        
        int minIdx = st.getMinIdx(0, 0, heights.length-1, l, r, heights);
        
        int area1 = heights[minIdx]*(r-l+1);
        int area2 = solve(heights, st, l, minIdx-1);
        int area3 = solve(heights, st, minIdx+1, r);
        
        return Math.max(area1, Math.max(area2, area3));
    }
}
class segmentTree{
    int[] tree;
    int[] idxTree;
    segmentTree(int n){
        tree = new int[4*n];
        idxTree = new int[4*n];
    }
    
    void build(int node, int l, int r, int[]a){
        if(l == r){
            tree[node] = a[l];
            idxTree[node] = l;
            return;
        }
        int mid = (l+r)/2;
        
        build(2*node+1, l, mid, a);
        build(2*node+2, mid+1, r, a);
        
        if(tree[2*node+1] < tree[2*node+2]){
            tree[node] = tree[2*node+1];
            idxTree[node] = idxTree[2*node+1];
        }
        else{
            tree[node] = tree[2*node+2];
            idxTree[node] = idxTree[2*node+2];
        }
    }
    int getMinIdx(int node, int l, int r, int start, int end, int[] heights){
        if(start > r || end < l)return Integer.MAX_VALUE;
        if(l >= start && r <= end)return idxTree[node];
        
        int mid = (l+r)/2;
        int idx1 = getMinIdx(2*node+1, l, mid, start, end, heights);
        int idx2 = getMinIdx(2*node+2, mid+1, r, start, end, heights);
        
        if(idx1 == Integer.MAX_VALUE)return idx2;
        if(idx2 == Integer.MAX_VALUE)return idx1;
        
        if(heights[idx1] < heights[idx2])return idx1;
        return idx2;
    }
}
