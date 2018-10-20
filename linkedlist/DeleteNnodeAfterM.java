package linkedlist;

/*Repeatedly Delete N nodes after M nodes of a Linked list
Given a linked list and two integers M and N. Traverse the 
linked list such that you retain M nodes then delete next N nodes,
continue the same until end of the linked list.

Input:
M = 2, N = 2
Linked List: 1->2->3->4->5->6->7->8
Output:
Linked List: 1->2->5->6

The main part of the problem is to maintain proper links between 
nodes, make sure that all corner cases are handled.*/
public class DeleteNnodeAfterM {

	Node head;
	public static class Node {
		int data;
		Node next;
		Node(int data) {
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
	
	//delete n nodes after m and repeat this process till the end
	public void repeatDelete(int m, int n) {
		Node current = head;
		Node temp = null;
		while(current != null) {
			for(int i=1; i<m && current !=null; i++) {
				current = current.next;
			}
			if(current != null) {
				temp = current.next;
				for(int i=0; i<n && temp != null; i++) {
					temp = temp.next;
				}
				current = current.next = temp;
			}
		}
	}
	
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DeleteNnodeAfterM obj = new DeleteNnodeAfterM();
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.addNode(new Node(6));
		obj.addNode(new Node(7));
		obj.addNode(new Node(8));
		obj.addNode(new Node(9));
		obj.repeatDelete(2, 2);
		obj.print();
	}

}
