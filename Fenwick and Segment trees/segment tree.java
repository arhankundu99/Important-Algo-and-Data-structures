// find minimum in a range
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        
        int x = power(n,1);
        SegmentTree tree = new SegmentTree(2*x-1);
        for(int i=0;i<n;i++)a[i] = scan.nextInt();

        tree.build(0, 0, n-1, a);

        while(q-->0)
        {
            String s = scan.next();
            if(s.equals("q"))
            {
                int l = scan.nextInt();
                int r = scan.nextInt();
                System.out.println(tree.query(0, 0, n-1, l-1, r-1));
            }
            else
            {
                int idx = scan.nextInt();
                int val = scan.nextInt();
                tree.update(0, 0, n-1, idx-1, val);
            }
        }
    }
    public static int power(int n, int curr)
    {
        if(curr >= n)return curr;
        return power(n, 2*curr);
    }
}
class SegmentTree
{
    int[] tree;
    SegmentTree(int n)
    {
        tree = new int[n];
    }
    void update(int node, int start, int end, int idx, int val)
    {
        if(idx < start || idx > end)return;
        if(start == end)
        {
            tree[node] = val;
            return;
        }
        int mid = (start+end)/2;
        if(idx <= mid)update((2*node)+1, start, mid, idx, val);
        else update((2*node)+2, mid+1, end, idx, val);

        tree[node] = Math.min(tree[2*node+1], tree[2*node+2]);
    }
    int query(int node, int start, int end, int l, int r)
    {
        if(start >= l && end <= r)return tree[node];
        if(start > r || end < l)return Integer.MAX_VALUE;

        int mid = (start+end)/2;

        int x = query(2*node+1, start, mid, l, r);
        int y = query(2*node+2, mid+1, end, l, r);

        return Math.min(x, y);
    }
    void build(int node, int start, int end, int[]a)
    {
        if(start == end)
        {
            tree[node] = a[start];
            return;
        }
        else
        {
            int mid = (start + end) / 2;
            build(2*node+1, start, mid, a);
            build(2*node+2, mid+1, end, a);
            tree[node] = Math.min(tree[2*node+1],tree[2*node+2]);
        }
    }
}
