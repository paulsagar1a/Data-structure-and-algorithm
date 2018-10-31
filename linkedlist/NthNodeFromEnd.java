/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Linked list
 * 
 * Write a program to return the nth node from the end of a linked list
 * eg. 1->2->3->4->5->6->7->8
 * return 3rd node from the end
 * in this case result = 6
 ************************************************************************/
package linkedlist;

public class NthNodeFromEnd {
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
	
	public Node returnNthNodeFromEnd(int n) {
		Node temp1 = head;
		Node temp2 = head;
		//go to the nth node from the beginning
		for(int i=0; i<n; i++) {
			temp1 = temp1.next;
		}
		//step temp2 one by one node till temp1=null
		while(temp1 != null) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp2;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthNodeFromEnd obj = new NthNodeFromEnd();
		obj.addNode(new Node(1));
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.addNode(new Node(6));
		obj.addNode(new Node(7));
		obj.addNode(new Node(8));
		System.out.println(obj.returnNthNodeFromEnd(3).data);
	}

}
