package com.test.freecharge;


public class FindJunctionNode {
	
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
	
	
	
	/*
	 * 
	 * 
	 * Approach : Iterate in reverse manner
	 * 
	 * check the common nodes, and find the last node after which both LL becomes different 
	 * 
	 * 
	 */
	private static Node findJunction(FindJunctionNode list1 , FindJunctionNode list2) {
		list1.reverse();
		
		list2.reverse();
		
		System.out.println("reverse list1: ");
		list1.prinlList();
		
		System.out.println("reverse list2: ");
		list2.prinlList();
		
		Node junction = list1.head;
		Node junction2 = list2.head;
		
		while (junction!=null) {
			if (junction.next.data == junction2.next.data) {
				junction = junction.next;
				junction2 = junction2.next;
				
				System.out.println("hhhheeereeee");
			}
			if (junction.next.data != junction2.next.data) {
				break;
			}
		}
		
		return junction;
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
	

	public static void main(String[] args) {
		FindJunctionNode list = new FindJunctionNode();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(70);
		list.add(80);
		
		System.out.println("Initial list: ");
		list.prinlList();
		
		FindJunctionNode list2 = new FindJunctionNode();
		
		list2.add(1);
		list2.add(3);
		list2.add(5);
		list2.add(9);
		list2.add(14);
		list2.add(40);
		list2.add(70);
		list2.add(80);
		
		System.out.println("Second list: ");
		list2.prinlList();
		
		
		Node junc = findJunction(list, list2);
		
		System.out.println("Junction node: "+ junc.data);
		

	}

}
