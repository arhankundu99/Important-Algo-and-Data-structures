// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.add(0);
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num: nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        SegmentTree st = new SegmentTree(min, max);
        for (int i = nums.length - 1; i >= 0; i--) {
            st.insert(nums[i]);

            if (nums[i] == min) {
                result.set(i, 0);
            } else {
                int count = st.getSum(min, nums[i] - 1);
                result.set(i, count);
            }
        }
        System.out.println(st.root.val);
        return result;
    }
}

class SegmentTree {
    SegmentTreeNode root;
    public SegmentTree(int start, int end) {
        root = new SegmentTreeNode(start, end);
    }

    public void insert(int num) {
        insert(root, num);
    }

    private void insert(SegmentTreeNode curr, int num) {
        int start = curr.start;
        int end = curr.end;

        if (start == end) {
            curr.val++;
            return;
        }

        int mid = start + (end - start) / 2;

        if (num <= mid) {
            if (curr.left == null) {
                curr.left = new SegmentTreeNode(start, mid);
            }
            insert(curr.left, num);
        } else {
            if (curr.right == null) {
                curr.right = new SegmentTreeNode(mid + 1, end);
            }
            insert(curr.right, num);
        }
        curr.val = (curr.left != null? curr.left.val: 0) + (curr.right != null? curr.right.val: 0);
    }

    public int getSum(int min, int max) {
        return getSum(root, min, max);
    }

    private int getSum(SegmentTreeNode curr, int min, int max) {
        if (curr == null) {
            return 0;
        }
        if (curr.start >= min && curr.end <= max) {
            return curr.val;
        }

        if (max < curr.start || min > curr.end) {
            return 0;
        }

        return getSum(curr.left, min, max) + getSum(curr.right, min, max);
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
}