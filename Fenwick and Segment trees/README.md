# Fenwick and Segment trees

## Important articles : 
<https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/#c217533> <br />
<https://medium.com/@adityakumar_98609/fenwick-tree-binary-index-tree-aca7824d9c2a> <br />
<https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/tutorial/> <br />
<https://cp-algorithms.com/data_structures/segment_tree.html> <br />

Updating range of indices [l, r]

```java
void updateRange(int node, int start, int end, int l, int r, int val)
{
    // out of range
    if (start > end or start > r or end < l)
        return;

    // Current node is a leaf node
    if (start == end)
    {
        // Add the difference to current node
        tree[node] += val;
        return;
    }

    // If not a leaf node, recur for children.
    int mid = (start + end) / 2;
    updateRange(node*2, start, mid, l, r, val);
    updateRange(node*2 + 1, mid + 1, end, l, r, val);

    // Use the result of children calls to update this node
    tree[node] = tree[node*2] + tree[node*2+1];
}
```
