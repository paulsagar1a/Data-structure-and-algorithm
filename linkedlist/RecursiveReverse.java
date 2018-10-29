/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Linked list
 * 
 * Reverse a Linked List using Recursion
 ************************************************************************/
package linkedlist;

public class RecursiveReverse {
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
	
	public void recursiveReverse() {
		head = reverseNode(head);
	}
	
	private Node reverseNode(Node node) {
		// TODO Auto-generated method stub
		Node newHead;
		//empty list
		if(node.next == null)
			return node;
		//reverse the rest link and put the first element at the end
		newHead = reverseNode(node.next);
		node.next.next = node;
		node.next = null;
		return newHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecursiveReverse obj = new RecursiveReverse();
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.addNode(new Node(6));
		obj.addNode(new Node(7));
		System.out.println("-----Before recursive reverse-----");
		obj.print();
		obj.recursiveReverse();
		System.out.println("-----After recursive reverse-----");
		obj.print();
	}

}
