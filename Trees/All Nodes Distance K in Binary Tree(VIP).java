// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, List<TreeNode>> map = new HashMap<>();
        
        traverse(map, root);
        
        Map<TreeNode, Integer> distMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        distMap.put(target, 0);
        if(k == 0)list.add(target.val);
        
        while(queue.size() != 0){
            TreeNode pop = queue.poll();
            
            if(map.containsKey(pop)){
                for(TreeNode edge: map.get(pop)){
                    if(!distMap.containsKey(edge)){
                        distMap.put(edge, distMap.get(pop)+1);
                        queue.add(edge);
                        if(distMap.get(edge) == k)list.add(edge.val);
                    }
                }
            }
        }
        return list;
        
    }
    public void traverse(Map<TreeNode, List<TreeNode>> map, TreeNode root){
        if(root == null)return;
        
        if(root.left != null){
            if(!map.containsKey(root))map.put(root, new ArrayList<>());
            if(!map.containsKey(root.left))map.put(root.left, new ArrayList<>());
            
            map.get(root).add(root.left);
            map.get(root.left).add(root);
        }
        
        if(root.right != null){
            if(!map.containsKey(root))map.put(root, new ArrayList<>());
            if(!map.containsKey(root.right))map.put(root.right, new ArrayList<>());
            
            map.get(root).add(root.right);
            map.get(root.right).add(root);
        }
        traverse(map, root.left);
        traverse(map, root.right);
    }
}
