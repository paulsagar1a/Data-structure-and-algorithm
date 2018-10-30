/************************************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Linked list
 * 
 * Merge a linked list into another linked list at alternate positions
 * Given two linked lists, insert nodes of second list into first list at 
 * positions of first list.
 * eg.  1->2->3->4
 *      5->6->7->8
 * o/p: 1->5->2->6->3->7->4->8
 ************************************************************************/
package linkedlist;

public class MargeTwoAlternatively {
	public static Node head1;
	public static Node head2;
	
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	public static void print(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	private static Node margeAlternativelt(Node head1, Node head2) {
		Node temp = head1;
		while(head1 != null && head2 != null) {
			Node temp1 = head1.next;
			Node temp2 = head2.next;
			head1.next = head2;
			head2.next = temp1;
			head1 = temp1;
			head2 = temp2;
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head2 = new Node(7);
		head2.next = new Node(8);
		head2.next.next = new Node(9);
		head2.next.next.next = new Node(10);
		head2.next.next.next.next = new Node(11);
		head2.next.next.next.next.next = new Node(12);
		head1 = margeAlternativelt(head1, head2);
		print(head1);
	}

}
