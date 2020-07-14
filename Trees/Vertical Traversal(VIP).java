// Note: Using DFS you would get the wrong answer
// https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
static ArrayList <Integer> verticalOrder(Node root)
    {
        int min = 0, max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(root.data);
        
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root, 0));
        while(queue.size() != 0){
            pair poll = queue.poll();
            Node node = poll.node;
            int level = poll.level;
            
            if(node.left != null){
                queue.add(new pair(node.left, level-1));
                if(!map.containsKey(level-1))map.put(level-1, new ArrayList<>());
                map.get(level-1).add(node.left.data);
                
                min = Math.min(min, level-1);
            }
            if(node.right != null){
                queue.add(new pair(node.right, level+1));
                if(!map.containsKey(level+1))map.put(level+1, new ArrayList<>());
                map.get(level+1).add(node.right.data);
                max = Math.max(max, level+1);
            }            
        }
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            for(int val: map.get(i))ans.add(val);
        }
        return ans;
    }
}
class pair{
    Node node;
    int level;
    pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
