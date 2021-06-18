//307. Range Sum Query - Mutable
//Difficulty: Medium

class NumArray {

    private segmentTree segmentTree;
    private int low, high, node;
    private int[] nums;
    public NumArray(int[] nums) {
        segmentTree = new segmentTree(nums.length);
        this.nums = nums;
        low = 0;
        high = nums.length - 1;
        node = 0;
        segmentTree.build(low, high, node, nums);
    }
    
    public void update(int idx, int val) {
        segmentTree.update(low, high, node, nums, idx, val);
    }
    
    public int sumRange(int left, int right) {
        return segmentTree.sumRange(low, high, node, nums, left, right);
    }
}
class segmentTree{
    private int[] tree;
    segmentTree(int n){
        tree = new int[4*n];
    }
    void build(int low, int high, int node, int[] nums){
        if(low > high)return;
        if(low == high){
            tree[node] = nums[low];
            return;
        }
        
        int mid = (low + high) / 2;
        
        build(low, mid, 2 * node + 1, nums);
        build(mid + 1, high, 2 * node + 2, nums);
        
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    void update(int low, int high, int node, int[] nums, int idx, int val){
        if(low > high)return;
        if(low == high){
            tree[node] = val;
            return;
        }
        
        int mid = (low + high) / 2;
        if(idx <= mid)update(low, mid, 2 * node + 1, nums, idx, val);
        else update(mid + 1, high, 2 * node + 2, nums, idx, val);
        
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }
    int sumRange(int low, int high, int node, int[] nums, int left, int right){
        if(low > high)return 0;
        
        //case1 left <= low <= high <= right
        if(low >= left && right >= high)return tree[node];
        
        //case2 right < low or left > high
        if(right < low || left > high)return 0;
        
        int mid = (low + high) / 2;
        
        return sumRange(low, mid, 2 * node + 1, nums, left, right) + 
               sumRange(mid + 1, high, 2 * node + 2, nums, left, right);
        
    }
}
