// https://practice.geeksforgeeks.org/problems/node-at-distance/1
class Solution{

    int printKDistantfromLeaf(Node root, int k)
    {
        Set<Node> set = new HashSet<>();
        f(root, k, new ArrayList<>(), set);
        return set.size();
    }
    void f(Node root, int k, List<Node> list, Set<Node> set){
        if(root == null)return;
        
        list.add(root);
        if(root.left == null && root.right == null){
            if(list.size() >= k + 1)set.add(list.get(list.size() - k - 1));
        }
        f(root.left, k, list, set);
        f(root.right, k, list, set);
        list.remove(list.size()-1);
    }
}
