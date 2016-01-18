class SumTree {
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

		void convertToSumTreeHelper() {
			convertToSumTree(this);
			display();
		}

		void inOrderTraversal(TreeNode node) {
			if(node == null)
				return;

			inOrderTraversal(node.left);
			System.out.print(node.data+" ");
			inOrderTraversal(node.right);
		}

		int convertToSumTree(TreeNode node) {
			if(node == null)
				return 0;

			int oldData = node.data;

			node.data = convertToSumTree(node.left)+convertToSumTree(node.right);

			return node.data + oldData;
		}
	}

	public static void main(String[] args) {
		//insertion of dummy data
		TreeNode root = new TreeNode(20);
		root.insert(30);
		root.insert(10);
		root.insert(5);
		root.convertToSumTreeHelper();
	}
}