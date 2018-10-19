public class BST {
	class Node {
		int data;
		Node left, right;
		Node(int a) {
			data = a;
			left = right = null;
		}
	}
	Node insert(Node root, int a) {
		if(root == null) {
			return new Node(a);
		}
		if(root.data > a) {
			root.left = insert(root.left, a);
		}
		root.right = insert(root.right, a);
		return root;
	}
	void inorder(Node root) {
		if(root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}

	public static void main(String[] args) {
		BST c = new BST();
		Node root = null;
		int[] arr = {1,2,3,4,5,6,7};
		for(int i: arr) {
			root = c.insert(root, i);
		}
		c.inorder(root);
	}
}
