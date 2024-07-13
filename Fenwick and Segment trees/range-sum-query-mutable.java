//307. Range Sum Query - Mutable
//Difficulty: Medium
class NumArray {
    SegmentTree st;
    public NumArray(int[] nums) {
        st = new SegmentTree(nums);
    }
    
    public void update(int index, int val) {
        st.update(index, val);
        // System.out.println(st.root.val + " " + st.root.left.val + " " + st.root.right.val);
    }
    
    public int sumRange(int left, int right) {
        return st.sumRange(left, right);
    }
}

class SegmentTree {
    public SegmentTreeNode root;
    public SegmentTree(int[] nums) {
        root = build(nums);
    }

    
    public SegmentTreeNode build(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        if (left == right) {
            return new SegmentTreeNode(left, right, nums[left]);
        }

        int mid = left + (right - left) / 2;

        SegmentTreeNode curr = new SegmentTreeNode(left, right);
        curr.left = build(nums, left, mid);
        curr.right = build(nums, mid + 1, right);
        curr.val = (curr.left != null? curr.left.val: 0) + (curr.right != null? curr.right.val: 0);

        return curr;
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(SegmentTreeNode node, int index, int val) {
        if (node == null) {
            return;
        }

        int start = node.start;
        int end = node.end;

        if (start == end) {
            node.val = val;
            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node.left, index, val);
        } else {
            update(node.right, index, val);
        }

        node.val = (node.left != null? node.left.val: 0) + (node.right != null? node.right.val: 0);

    }

    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }

    private int sumRange(SegmentTreeNode node, int left, int right) {
        if (node == null) {
            return 0;
        }

        int start = node.start;
        int end = node.end;



        if (left <= start && right >= end) {
            return node.val;
        }

        if (left > end || right < start) {
            return 0;
        }

        if (start == end) {
            return node.val;
        }

        return sumRange(node.left, left, right) + sumRange(node.right, left, right);
    }
}

class SegmentTreeNode {
    int start;
    int end;
    int val;
    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public SegmentTreeNode(int start, int end, int val) {
        this.start = start;
        this.end = end;
        this.val = val;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */

 

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
