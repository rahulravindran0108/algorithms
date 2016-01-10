//computing the sum of two number on linked list in forward order without reversing
//Assumption:
//Both the list have the same length
class AdditionLinkedList {

	public static class Node {
		int data;
		int carry;
		Node next;
		Node result;

		Node(int carry,int data,Node next) {
			this.data = data;
			this.carry = carry;
			this.next = next;

		}

		Node() {

		}

		public void setNext(Node next) {
			this.next = next;
		}

		
	}

	static Node ResultNode;
	

	static Node addList(Node l1, Node l2) {
		if(l1 == null || l2 == null) {

			return new Node();
		}


		//this will first stop and return an empty sum node on 
		// 6,4 digit of the input
		Node sum = addList(l1.next,l2.next);

		int value = sum.carry + l1.data + l2.data;

		//sum 
		//System.out.println(value % 10);
		sum.data = value % 10;
		//carry
		//System.out.println(value / 10);
		sum.carry = value / 10;

		//add to result
		if(ResultNode == null) {
			ResultNode = new Node(sum.carry,sum.data,null);
		} else {
			Node temp = ResultNode;
			ResultNode = sum;
			ResultNode.setNext(temp);
		}

		return sum;

	}

	//debug method for printing
	static void display(Node n) {
		while(n!=null) {
			System.out.print(n.data+" ");
			n = n.next;
		}

		System.out.println();
	}

	//checks if there is carry
	static void checkForCarry() {
		if(ResultNode.carry == 1) {
			Node temp = ResultNode;
			ResultNode = new Node(0,1,temp);
		}
	}

	public static void main(String[] args) {

		//head of first node
		//represents number 56
		Node n = new Node(0,5,null);
		n.setNext(new Node(0,6,null));

		//head of th second node
		//represents number 84
		Node n2 = new Node(0,8,null);
		n2.setNext(new Node(0,4,null));

		//now perform addition of these two linke list
		addList(n,n2);
		checkForCarry();

		display(ResultNode);

	}
}