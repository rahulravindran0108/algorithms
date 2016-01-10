/*
Implement an algorithm to find the kth to last element of a singly linked list.
Author: Rahul Ravindran
*/

import java.util.*;

class KElementRemoval {

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

		Node findKthToTheLastElement(int k) {

			Node pointer1 = this;
			Node pointer2 = this;

			for(int i=0;i<k;i++) {
				while(pointer1.next!=null) {
					pointer1 = pointer1.next;
				}
			}

			while(pointer1.next!=null) {
				pointer1 = pointer1.next;
				pointer2 = pointer2.next;
			}

			return pointer2.next;

		}
	}

	public static void main(String [] args) {

		Node head = new Node(20);
		head.insertDataAtEnd(new Node(30));
		head.insertDataAtEnd(new Node(40));
		head.insertDataAtEnd(new Node(40));
		head.insertDataAtEnd(new Node(50));

		System.out.println(head.findKthToTheLastElement(3).data);

	}
}