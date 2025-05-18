package com.project.work.linkedlist;

public class LL_InsertionAndReversal {
	
	
	// Node class - holds data and reference to next node
	// Also the 'LinkedList' class
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
		Node newNode = new Node(data);				// creating the node
		
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;					// assigning current Node, so that can start iteration
			
			while (current.next != null) {			// iss condition ko yaad rakho
				current = current.next;				// or iss line ko
			}
			
			current.next = newNode;					// here you attached the new node to the existing LinkedList at the end
		}
	}
	
	
	// Inserting at a specific index
	public void insertAt(int index, int data) {
		Node newNode = new Node(data);				// creating the node
		
		// edge scenario
		if (index == 0) {							// if need to attach at the head (0)
			newNode.next = head;
			head = newNode;
			return;
		}
		
		Node current = head;
		int counter = 0;
		
		// edge scenario
		if (current == null) {
			System.out.println("Index out of bounds");
			return;
		}
		
		while (current != null && counter < index-1) {
			current = current.next;
			counter++;
		}
		
		newNode.next = current.next;				// first attach new Node
		current.next = newNode;						// then detach current node and attach to new Node
	}
	
	
	// Reversing the linked list
	public void reverse() {
		Node previous = null;						// previous becomes the new head of the reversed list
        Node current = head;						// simple starting from the head, start iteration
        
        while (current != null) {					// iteration
            Node nextNode = current.next;			// "bookmark" the next node/ "hold" the next node so you don't lose access to the list 

            current.next = previous;				// this line reverses the pointer backwards'
            
            previous = current;						// 'previous' moves to where 'current' was 
            current = nextNode;						// 'current' moves to the 'next' node
        }
        
        head = previous;							// 'previous' is the last non-null node - it's now the *new head*
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
	
	

	/*
	 *	main method to test 
	 */
	public static void main(String[] args) {
		LL_InsertionAndReversal list = new LL_InsertionAndReversal();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(70);
		list.add(80);
		
		System.out.println("Initial list: ");
		list.prinlList();
		
		
		list.insertAt(3, 25);
		System.out.print("After inserting 25 at index 3: \n");
		list.prinlList();
		
		
		list.reverse();
		System.out.print("After reversing the list: \n");
		list.prinlList();
	}

}
