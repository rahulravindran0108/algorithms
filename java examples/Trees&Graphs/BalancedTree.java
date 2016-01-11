/*
Implement a function to check if a binary tree is balanced.
For the purposes of this question, a balanced tree is defined
to be a tree such that the heights of the two subtrees
of any node never differ by more than one.

Author: Rahul Ravindran
*/

class BalancedTree {

	static class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;

		TreeNode(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}

		void insert(int data) {
			if(data > this.data) {
				if(right == null) 
					this.right = new TreeNode(data);
				else 
					this.right.insert(data);
			} else {
				if(left == null)
					this.left = new TreeNode(data);
				else
					this.left.insert(data);
			}
		}

		void display() {
			inOrderTraversal(this);
		}

		void inOrderTraversal(TreeNode node) {
			if(node == null)
				return;

			inOrderTraversal(node.left);
			System.out.print(node.data+" ");
			inOrderTraversal(node.right);
		}

		boolean isBalanced() {
			if(this == null)
				return true;

			int heightDiff = getHeight(this.left) - getHeight(this.right);

			if(Math.abs(heightDiff) > 1)
				return false;
			else {
				if(this.left == null && this.right == null)
					return true;
				else if(this.left == null || this.right == null)
					return false;
				else
					return this.left.isBalanced() && this.right.isBalanced();
			} 
				
		}

		int getHeight(TreeNode root) {
			if(root == null)
				return 0;
			return Math.max(getHeight(root.left),getHeight(root.right)) + 1;
		}

	} 

	public static void main(String[] args) {

		//insertion of dummy data
		TreeNode root = new TreeNode(20);
		root.insert(30);
		root.insert(10);
		root.insert(5);
		root.display();
		
		System.out.println(root.isBalanced());
	}
}