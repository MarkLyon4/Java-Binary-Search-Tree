
public class main {
	public static void main(String[] args){
		BST tree = new BST();
		
		tree.insertNode(tree.Root, 4);
		tree.insertNode(tree.Root, 5);
		tree.traverse(tree.Root);
		tree.deleteNode(tree.Root, 6);
		tree.deleteNode(tree.Root, 5);
		tree.traverse(tree.Root);
		tree.search(tree.Root, 4);
		tree.search(tree.Root, 3);
		tree.exit();
	}
}
