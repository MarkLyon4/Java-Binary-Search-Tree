
public class BST {
	
	Node Root;
	
	BST(){
		Root = null;
	}
	
	public void insertNode(Node n, int data){
		if (n == null){ //Deals with an empty tree
			n = new Node(data);
			Root = n;
		}
		else if (data < n.data && n.left == null){ //Puts it in an empty left subtree
			n.left = new Node(data);
			n.left.parent = n;
		}
		else if (data > n.data && n.right == null){ //Puts it in an empty right subtree
			n.right = new Node(data);
            n.right.parent = n;
        }
		else if (data == n.data){ //Makes sure there are no duplicates
			n.data = data;
		}
        else{
            if (data < n.data){
                insertNode(n.left, data); //explore left subtree
            }else{
                insertNode(n.right, data);} //explore right subtree
        }
		System.out.format("%d was inserted successfully!\n", data);
	}
	
	public void deleteNode(Node n, int data){
		if (n == null){
			System.out.format("%d does not exist\n", data);
			return;
		}
		if (n.data == data) {
	        if ((n.left == null) && (n.right == null)){// leaf node
	        	if (n == Root) {
	        		Root = null;
	        	}
	        	else {
	        		if (n == n.parent.left) {
	        			n.parent.left = null;
	        		}
	        		else {
	        			n.parent.right = null;
	        		}
	        	}
	        }
	        else if ((n.left != null) && (n.right != null)) {// node with two children
	            n.data = findMinimumAndReturnWithDelete(n.right);
	        }
	        // either left child or right child
	        else if (n.left != null) {
	        	if (n == Root) {
	        		n.left.parent = null;
	        		Root = n.left;
	        		n = null;
	        	}
	        	else {
	        	    n.left.parent = n.parent;
	        	    n.parent.left = n.left;
	        	    n = null;
	        	}
	        }
	        else if (n.right != null) {
	        	if (n == Root) {
	        		n.right.parent = null;
	        		Root = n.right;
	        		n = null;
	        	}
	        	else {
	        	    n.right.parent = n.parent;
	        	    n.parent.right = n.right;
	        	    n = null;
	        	}
	        }
	        System.out.format("%d deleted successfully!\n", data);
	        return;
	    }
	    if (n.data > data) {
	        deleteNode(n.left, data);//explore left subtree
	    } else {
	        deleteNode(n.right, data);//explore right subtree  
	    }
	}

	int findMinimumAndReturnWithDelete(Node n) {
	    if (n.left == null) {
	        int v = n.data;
	        n = null;
	        return v;
	    }
	    return findMinimumAndReturnWithDelete(n.left);
	}
	
	public boolean search(Node n, int data){
	    if (n == null){ //deals with an empty tree
	    	System.out.format("%d does not exist.\n", data);
	        return false;
	    }
	    else if (n.data == data){ //Has found it
	    	System.out.format("Found %d!\n", data);
	        return true;
	    }
	    else{
	        if (data < n.data){
	            return search(n.left, data); //Checks left sub tree
	        }else{
	            return search(n.right, data);} //Checks right sub tree
	        }
	    }
	
	public void traverse(Node n){
        if (n != null){
            traverse(n.left); //Handles left
            System.out.println("Traversing... " + n.data + " ");
            traverse(n.right); //Handles right
        }
    }
	
	public void exit(){
		System.out.print("Exiting!");
		System.exit(0);
	}

}
