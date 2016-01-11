/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/

import java.util.*;


class LevelSearchBST {

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

		void createLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists,
							int level) {

			if(root == null)
				return;

			LinkedList<TreeNode> list = null;

			if(lists.size() == level) {
				list = new LinkedList<TreeNode>();

				lists.add(list);
			} else
				list = lists.get(level);

			list.add(root);

			createLinkedList(root.left, lists, level+1);
			createLinkedList(root.right,lists,level+1);

		}

		ArrayList<LinkedList<TreeNode>> createLinkedList() {
			ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
			createLinkedList(this, lists, 0);
			return lists;
		}	

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(20);
		root.insert(30);
		root.insert(10);
		root.insert(5);

		ArrayList<LinkedList<TreeNode>> result = root.createLinkedList();

		for(LinkedList<TreeNode> r : result) {
			System.out.println(r.size());
		}
		
	}
}