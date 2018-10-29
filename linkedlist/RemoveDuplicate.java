/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Linked list
 * 
 * Remove duplicates from an unsorted linked list
 ************************************************************************/
package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

	public Node head;
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	public void addNode(Node node) {
		if(head == null) {
			head = node;
		} else {
			Node temp = head;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public void removeDuplicate() {
		Set<Integer> set = new HashSet<>();
		Node current = head;
		Node previous = null;
		while(current != null) {
			int data = current.data;
			if(set.contains(data)) {
				previous.next = current.next;
			} else {
				set.add(data);
				previous = current;
			}
			current = current.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicate obj = new RemoveDuplicate();
		obj.addNode(new Node(1));
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.addNode(new Node(4));
		System.out.println("-----Before removing the duplicate data-----");
		obj.print();
		obj.removeDuplicate();
		System.out.println("-----After removing the duplicate data-----");
		obj.print();
	}

}
