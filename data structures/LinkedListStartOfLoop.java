/*
Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
Author: Rahul Ravindran
*/

class LinkedListStartOfLoop {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		void insertDataAtEnd(Node toInsert) {
			Node head = this;
			while(head.next!=null && head!=null) {
				head = head.next;
			}
			head.next = toInsert;
		}

		void display() {
			Node head = this;
			while(head!=null && head.next!=null) {
				System.out.println(head.data);
				head = head.next;
			}
			System.out.println(head.data);
		}

		void loopAtIndex(int k) {
			Node head = this;
			Node toLoop = null;
			int counter = 1;
			while(head.next!=null) {
				if(counter == k) {
					toLoop = head;
				}
				head = head.next;
				counter+=1;
			}
			head.next = toLoop;
		}

		Node returnBeginLoopNode() {
			Node runner = this;
			Node slowRunner = this;

			while(runner != null && runner.next!=null) {
				slowRunner = slowRunner.next;
				runner = runner.next.next;
				if(slowRunner == runner)
					break;
			}

			slowRunner = this;
			while(slowRunner != runner) {
				runner = runner.next;
				slowRunner = slowRunner.next;
			}

			return runner;
		}

	}

	public static void main(String [] args) {

		createStructure();
	
	}

	static void createStructure() {
		Node head = new Node(20);
		head.insertDataAtEnd(new Node(30));
		head.insertDataAtEnd(new Node(40));
		head.insertDataAtEnd(new Node(50));
		head.insertDataAtEnd(new Node(150));
		head.insertDataAtEnd(new Node(250));
		head.insertDataAtEnd(new Node(350));
		head.insertDataAtEnd(new Node(450));
		head.insertDataAtEnd(new Node(550));
		head.insertDataAtEnd(new Node(650));

		//loop at 50
		head.loopAtIndex(4);

		//call begin loop
		System.out.println(head.returnBeginLoopNode().data);
	}


}