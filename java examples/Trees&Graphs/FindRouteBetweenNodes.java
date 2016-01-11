import java.util.*;

class FindRouteBetweenNodes {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	static class Graph {
		Node [] nodes;
		int numberOfNodes;

		Graph(int numberOfNodes) {	
			this.numberOfNodes = numberOfNodes;
			nodes = new Node[numberOfNodes+1];
		}

		//inserts node b, which is adjacent to node a
		void insertAdjacent(int index,Node b) {

			//initialize if no index does not exist
			if(nodes[index] == null)
				nodes[index] = new Node(index);

			Node currentNode = nodes[index];

			while(currentNode.next != null)
				currentNode = currentNode.next;

			currentNode.next = b;
		}

		void display() {
			for(int i=1;i<nodes.length;i++) {
				System.out.print("Node "+i+" ->");
				Node currentNode = nodes[i];
				while(currentNode != null) {
					currentNode = currentNode.next;
					if(currentNode!=null)
						System.out.print(currentNode.data+" ");

				}
				System.out.println();		
			}
			
		}

		ArrayList<Node> getAdjacent(int index) {
			ArrayList<Node> result = new ArrayList<Node>();

			Node currentNode = nodes[index];

			while(currentNode.next!=null) {
				result.add(currentNode.next);
				currentNode = currentNode.next;
			}

			return result;
		}


		//can be used to find the route between two nodes
		void BreadthFirstSearch(int start) {
			Node currentNode = nodes[start];
			int [] visited = new int[this.numberOfNodes+1];

			LinkedList<Node> queue = new LinkedList<Node>();
			queue.add(currentNode);

			while(!queue.isEmpty()) {

				Node currentParent = queue.removeFirst();
				System.out.print(currentParent.data+ " ");
				visited[currentParent.data] = 1;

				ArrayList<Node> adjacent = this.getAdjacent(currentParent.data);

				for(Node element : adjacent) 	
					if(visited[element.data] == 0)
						queue.push(element);
				
			}
		}

	}



	public static void main(String[] args) {
		Graph g = new Graph(3);

		g.insertAdjacent(1,new Node(3));
		g.insertAdjacent(2,new Node(3));
		g.insertAdjacent(3,new Node(1));
		g.insertAdjacent(3, new Node(2));

		g.BreadthFirstSearch(1);

	}

}