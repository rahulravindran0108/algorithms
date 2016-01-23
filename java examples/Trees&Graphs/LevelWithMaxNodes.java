import java.util.*;

class LevelWithMaxNodes {

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

		int maxNodeHelper() {
			return maxNodesLevel(this);
		}

		int maxNodesLevel(TreeNode root) {
			if(root == null)
				return -1;

			Queue<TreeNode> stackOfNodes = new LinkedList<TreeNode>();
			stackOfNodes.add(root);

			int level = 0, answer = 0;
			int max = -10000;

			while(true) {

				int nodeCount = stackOfNodes.size();

				if(nodeCount > max) {
					answer = level;
					max = nodeCount;
				}

				if(nodeCount == 0)
					break;

				while(nodeCount > 0) {
					TreeNode poppedNode = (TreeNode) stackOfNodes.remove();
					if(poppedNode.left!=null)
						stackOfNodes.add(poppedNode.left);
					if(poppedNode.right!=null)
						stackOfNodes.add(poppedNode.right);
					nodeCount--;
				}
				level++;

			}

			return answer;

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.insert(30);
		root.insert(10);
		root.insert(5);
		root.insert(25);
		root.insert(60);
		
		System.out.println(root.maxNodeHelper());
	}

}