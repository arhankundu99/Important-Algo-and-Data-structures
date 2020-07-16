// https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1

public void serialize(Node root, ArrayList<Integer> A) {
	    if(root == null)
	    {
	        A.add(Integer.MAX_VALUE);
	        return;
	    }
	    A.add(root.data);
	    Queue<Node>queue = new LinkedList<>();
	    queue.add(root);
	    
	    while(queue.size() != 0){
	        Node node = queue.poll();
	        if(node.left == null){
	            A.add(Integer.MAX_VALUE);
	        }
	        else{
	            A.add(node.left.data);
	            queue.add(node.left);
	        }
	        if(node.right == null){
	            A.add(Integer.MAX_VALUE);
	        }
	        else{
	            A.add(node.right.data);
	            queue.add(node.right);
	        }
	    }
	    //System.out.println(A);
	}

    public Node deSerialize(ArrayList<Integer> A){
        if(A.size() == 0 || A.get(0) == Integer.MAX_VALUE)return null;
        Node root = new Node(A.get(0));
        Queue<Node>queue = new LinkedList<>();
        queue.add(root);
        int idx = 0;
        while(queue.size() != 0){
            Node node = queue.poll();	
            
            idx++;
            
            if(idx < A.size() && A.get(idx) != Integer.MAX_VALUE){
                node.left = new Node(A.get(idx));
                queue.add(node.left);
            }
            idx++;
            
            if(idx < A.size() && A.get(idx) != Integer.MAX_VALUE){
                node.right = new Node(A.get(idx));
                queue.add(node.right);
            }
        }
        return root;
    }
