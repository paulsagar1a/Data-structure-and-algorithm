package linkedlist;

/*Given a singly linked list, determine if its a palindrome. 
 * Return 1 or 0 denoting if its a palindrome or not, respectively.

Notes:
- Expected solution is linear in time and constant in space.

For example,
List 1–>2–>1 is a palindrome.
List 1–>2–>3 is not a palindrome.*/

public class PalindromeTest {
	/*Solution:

		This method takes O(n) time and O(1) extra space.
		1) Get the middle of the linked list.
		2) Reverse the second half of the linked list.
		3) Check if the first half and second half are identical.
		4) Construct the original linked list by reversing the 
		second half again and attaching it back to the first half.*/
	
	//Time Complexity O(n)
	//Auxiliary Space: O(1)
	
	public Node head;
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//add node to the linkedlist
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
	
	//checking palindrome
	public boolean isPalindrome() {
		//find the middle of the linkedlist
		Node midNode = findMiddle();
		Node secondHalf = midNode.next;
		midNode.next = null;
		Node firstHalf = head;
		//reverse secondHalf
		secondHalf = reverseNode(secondHalf);
		//checking firstHalf and secondHalf are identical or not
		boolean response = isIdentical(firstHalf, secondHalf);
		//before sending the response reverse the secondhalf and add
		// add it to the first half
		secondHalf = reverseNode(secondHalf);
		//add two nodes
		head = addTwoNodes(firstHalf, secondHalf);
		return response;
	}
	
	//finding the middle of the linkedlist
	public Node findMiddle() {
		Node temp1 = head;
		Node temp2 = head;
		while(temp2.next != null && temp2.next != null && temp2.next.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		return temp1;
	}
	
	//reversing a linked list
	public Node reverseNode(Node node) {
		Node current = node, previous = null, next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}
	
	//finding the two nodes are identical or not
	public boolean isIdentical(Node first, Node second) {
		while(first != null && second != null) {
			if(first.data != second.data)
				return false;
			first = first.next;
			second = second.next;
		}
		return true;
	}
	
	//adding two nodes
	public Node addTwoNodes(Node first, Node second) {
		Node tempHead = first;
		Node temp = tempHead;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = second;
		return tempHead;
	}
	
	//printing the linkedlist
	public void print() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromeTest obj = new PalindromeTest();
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(3));
		obj.addNode(new Node(2));
		obj.addNode(new Node(1));
		System.out.println(obj.isPalindrome());
	}

}
