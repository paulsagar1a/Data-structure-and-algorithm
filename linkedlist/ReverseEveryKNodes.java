/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Linked list
 * 
 * Reverse every k nodes of a linked list
 * Given a linked list and a number k. Reverse every k nodes in the list. 
 * Example : Input 1->2->3->4->5->6 and k = 2 Output 2->1->4->3->6->5
 ************************************************************************/
package linkedlist;

public class ReverseEveryKNodes {
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
	
	public void reverseEveryKNodes(int k) {
		head = reverseKNodes(head, k);
	}
	
	public Node reverseKNodes(Node head, int k) {
		int i = 0;
		Node current = head;
		Node next = null, previous = null;
		while(current != null && i<k) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
			i++;
		}
		if(next != null)
			head.next = reverseKNodes(next, k);
		return previous;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseEveryKNodes obj = new ReverseEveryKNodes();
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.addNode(new Node(6));
		obj.addNode(new Node(7));
		obj.addNode(new Node(8));
		System.out.println("----------Before----------");
		obj.print();
		obj.reverseEveryKNodes(3);
		System.out.println("----------After----------");
		obj.print();
	}

}
