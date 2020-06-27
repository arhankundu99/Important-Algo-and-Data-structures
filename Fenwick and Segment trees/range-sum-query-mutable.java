//307. Range Sum Query - Mutable
//Difficulty: Medium

class NumArray {

    segmentTree tree;
    int[] nums;
    public NumArray(int[] nums) {
        tree = new segmentTree(nums.length);
        if(nums.length != 0)tree.generateTree(0, nums.length-1, nums, 0);
        this.nums = nums;
    }
    
    public void update(int i, int val) {
        tree.update(0, nums.length-1, nums, 0, i, val);
    }
    
    public int sumRange(int i, int j) {
        return tree.sumRange(0, nums.length-1, nums, i, j, 0);
    }
}
class segmentTree{
    int[] tree;
    public segmentTree(int n){
        tree = new int[4*n];
    }
    void generateTree(int left, int right, int[] nums, int node){
        if(left == right){
            tree[node] = nums[left];
            return;
        }
        int mid = (left + right)/2;
        generateTree(left, mid, nums, 2*node+1);
        generateTree(mid+1, right, nums, 2*node+2);
        
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    void update(int left, int right, int[] nums, int node, int idx, int val)
    {
        if(left == right){
            tree[node] = val;
            return;
        }
        int mid = (left + right)/2;
        if(idx <= mid)update(left, mid, nums, 2*node+1, idx, val);
        else update(mid+1, right, nums, 2*node+2, idx, val);
        
        tree[node] = tree[2*node+1] + tree[2*node+2];
    }
    int sumRange(int left, int right, int[] nums, int i, int j, int node)
    {
        // given range completely overlaps with the interval
        if(i <= left && j >= right)return tree[node];
        
        //given range has no intersection with the interval
        if(j < left || i > right)return 0;
        
        //given range has partial intersection with the interval
        int mid = (left + right)/2;
        return sumRange(left, mid, nums, i, j, 2*node+1) + sumRange(mid+1, right, nums, i, j, 2*node+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
