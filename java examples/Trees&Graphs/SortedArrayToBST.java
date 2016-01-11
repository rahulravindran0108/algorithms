/*
Given a sorted (increasing order) array with unique integer elements,
write an algorithm to create a binary search tree with minimal height.
*/

class SortedArrayToBST {


	static class TreeNode {
		int data;
		TreeNode right;
		TreeNode left;

		TreeNode(int data) {
			this.data = data;
			this.right = null;
			this.left = null;
		}

		TreeNode() {

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

		TreeNode createMinimalBST(int [] arr, int start, int end) {
			if(end < start)
				return null;

			int mid = (start+end) / 2;

			TreeNode root = new TreeNode(arr[mid]);

			root.left = createMinimalBST(arr,start,mid-1);
			root.right = createMinimalBST(arr,mid+1,end);
			return root;
		}	

	}

	public static void main(String[] args) {
		int [] input = {1,2,3};	
		TreeNode result = new TreeNode().
			createMinimalBST(input,0,input.length-1);

		result.display();
	}
}