/*
Implement a function to check if a linked list is a palindrome.
*/
import java.util.*;

class LinkedListPalindrome {

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

		boolean isPalindrome() {
			Node runner = this;
			Node slowRunner = this;

			Stack<Integer> stackOfElements = new Stack<Integer>();

			while(runner!=null && runner.next!=null) {
				stackOfElements.push(slowRunner.data);
				slowRunner = slowRunner.next;
				runner = runner.next.next;
			}

			if(runner!=null)
				slowRunner = slowRunner.next;

			while(slowRunner!=null) {
				int top = stackOfElements.pop().intValue();

				if(top != slowRunner.data)
					return false;
				else
					slowRunner = slowRunner.next;
			}

			return true;


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

	public static void main(String[] args) {
		Node head = new Node(1);
		head.insertDataAtEnd(new Node(2));
		head.insertDataAtEnd(new Node(2));
		head.insertDataAtEnd(new Node(2));
		head.insertDataAtEnd(new Node(2));
		head.insertDataAtEnd(new Node(1));

		System.out.println(head.isPalindrome());
	}
}