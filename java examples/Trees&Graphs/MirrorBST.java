class MirrorBST {

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

		void mirrorBST() {
			if(this == null)
				return;
			TreeNode temp = this.left;
			this.left = this.right;
			this.right = temp;
			if(this.left != null)
				this.left.mirrorBST();
			if(this.right != null)
				this.right.mirrorBST();
		}
	}
	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.insert(30);
		root.insert(10);
		root.insert(5);

		root.display();
		root.mirrorBST();

		root.display();
		
	}
}