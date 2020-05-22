// HackerEarth Easy Queries Problem
//https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/easy-queries-751f9372/description/

import java.util.*;

class TestClass {
    public static void main(String args[]) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int q = scan.nextInt();
        segmentTree tree = new segmentTree(n);
        int[]a = new int[n];
        for(int i=0;i<n;i++)a[i] = scan.nextInt();

        tree.build(0, 0, a.length-1, a);

        while(q-->0)
        {
            int l = scan.nextInt();
            if(l == 1)
            {
                int idx = scan.nextInt();
                tree.update(0, 0, a.length-1, idx);
            }
            else
            {
                int idx = scan.nextInt();

                int idx1 = -1, idx2 = -1;
                if(idx != 0)idx1 = tree.searchL(0, 0, a.length-1, idx);
                if(idx != a.length-1)idx2 = tree.searchR(0, 0, a.length-1, idx);

                System.out.println(idx1+" "+idx2);
            }
        }
    }
}
class segmentTree
{
    int[]tree;
    segmentTree(int n)
    {
        tree = new int[4*n];
    }
    void build(int node, int start, int end, int[]a)
    {
        if(start == end)
        {
            tree[node] = a[start];
            return;
        }
        int mid = (start+end)/2;
        build(2*node+1, start, mid, a);
        build(2*node+2, mid+1, end, a);
        tree[node] = tree[2*node+1]+tree[2*node+2];    
    }
    void update(int node, int start, int end, int idx)
    {
        if(idx < start || idx > end)return;
        if(start == end)
        {
            tree[node] = 1;
            return;
        }
        int mid = (start+end)/2;
        if(idx <= mid)update(2*node+1, start, mid, idx);
        else update(2*node+2, mid+1, end, idx);

        tree[node] = tree[2*node+1]+tree[2*node+2];
    }
    int searchL(int node, int start, int end, int idx)
    {
        
        if(idx <= start || tree[node] == 0)return -1;
        if(start == end)return start;
        
        int mid = (start+end)/2;
        int idx1 = searchL(2*node+2, mid+1, end, idx);
        if(idx1 != -1)return idx1;
        int idx2 = searchL(2*node+1, start, mid, idx);
        if(idx2 != -1)return idx2;

        return -1;
    }
    int searchR(int node, int start, int end, int idx)
    {
        if(idx >= end || tree[node] == 0)return -1;
        if(start == end)return start;

        int mid = (start+end)/2;
        int idx1 = searchR(2*node+1, start, mid, idx);
        if(idx1 != -1)return idx1;
        int idx2 = searchR(2*node+2, mid+1, end, idx);
        if(idx2 != -1)return idx2;

        return -1;
    }
}
