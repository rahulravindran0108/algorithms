/*
Write code to remove duplicates from an unsorted linked list.

Author: Rahul Ravindran
*/
import java.util.*;

class LinkedListDuplicateRemoval {

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

		void removeDuplicates() {
			Hashtable table = new Hashtable();
			Node previous = null;
			Node head = this;

			while(head.next!=null) {
				if(table.containsKey(head.data)) 
					previous.next = head.next;
				else {
					table.put(head.data, true);
					previous = head;
				}
				head = head.next;
			}

		}

	}

	public static void main(String [] args) {

		Node head = new Node(20);
		head.insertDataAtEnd(new Node(30));
		head.insertDataAtEnd(new Node(40));
		head.insertDataAtEnd(new Node(40));
		head.insertDataAtEnd(new Node(50));

		//output the nodes for checking
		head.display();

		head.removeDuplicates();

		System.out.println("After Removing Duplicates");
		head.display();

	}

}