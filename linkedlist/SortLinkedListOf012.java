package linkedlist;

/*Sort a Linked List of 0s, 1s and 2s
Given a Singly linked list with each node containing 
either 0, 1 or 2. Write code to sort the list.
Input : 1 -> 1 -> 2 -> 0 -> 2 -> 0 -> 1 -> 0
Output : 0 -> 0 -> 0 -> 1 -> 1 -> 1 -> 2 -> 2*/

public class SortLinkedListOf012 {
/*Solution:
	take three nodes such as zero, one and two
	add all the 0s to zero
	add all the 1s to one
	add all the 2s to two
	And finally
	combine all three nodes (zero,one,two)*/
	//Time complexity O(n)
	
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
	
	//sort 0s, 1s, 2s
	public void sortO12() {
		Node zeroHead = new Node(0);
		Node oneHead = new Node(0);
		Node twoHead = new Node(0);
		Node zero = zeroHead, one = oneHead, two = twoHead;
		Node temp = head;
		while(temp != null) {
			if(temp.data == 0) {
				zero.next = temp;
				zero = zero.next;
			} else if(temp.data == 1) {
				one.next = temp;
				one = one.next;
			} else {
				two.next = temp;
				two = two.next;
			}
			temp = temp.next;
		}
		//attach zero, one, two
		zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
		one.next = twoHead.next;
		two.next = null;
		head = zeroHead.next;
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
		SortLinkedListOf012 obj = new SortLinkedListOf012();
		obj.addNode(new Node(1));
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(0));
		obj.addNode(new Node(2));
		obj.addNode(new Node(0));
		obj.addNode(new Node(1));
		obj.addNode(new Node(0));
		System.out.println("-----before sort-----");
		obj.print();
		obj.sortO12();
		System.out.println("-----after sort-----");
		obj.print();
	}

}
