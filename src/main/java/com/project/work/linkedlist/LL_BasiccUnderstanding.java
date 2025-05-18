package com.project.work.linkedlist;

public class LL_BasiccUnderstanding {
	
	/*
	 * Implementing the LinkedList
	 */
	
	// Node class - holds data and reference to next node
	static class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
	}
	
	// head of the list
	private Node head;
	
	
	// add method (add new node at the end)
	public void add (int data) {
		Node newNode = new Node(data);
		
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			
			while (current.next != null) {			// iss condition ko yaad rakho
				current = current.next;				// or iss line ko
			}
			
			current.next = newNode;					// here you attached the new node to the existing LinkedList at the end
		}
	}
	
	
	// print all elements
	public void prinlList() {
		Node current = head;
		
		while (current != null) {
			System.out.println(current.data + "->");
			current = current.next;
		}
		
		System.out.println("null");
	}
	
	
	// delete method (delete node by value)
	private void delete(int data) {
		if (head == null) return;
		
		if (head.data == data) {
			head = head.next;
			return;
		}
		
		Node current = head;
		
		while (current.next != null && current.next.data != data) {
			current = current.next;
		}
		
		if (current.next != null) {
			current.next = current.next.next;		// here you detach the current node pointer to skip 1 node (next to next) 
		}
	}
	

	
	/*
	 *	main method to test 
	 */
	public static void main(String[] args) {
		LL_BasiccUnderstanding list = new LL_BasiccUnderstanding();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(70);
		list.add(80);
		
		System.out.println("Initial list: ");
		list.prinlList();
		
		list.delete(80);
		
		System.out.println("After deleting 80: ");
		list.prinlList();
	}

}
