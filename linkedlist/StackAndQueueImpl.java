package linkedlist;

/*Implement Stack and Queue using Linked List in Java*/
public class StackAndQueueImpl {
	Node head;
	Node front, rear; //this two attributes are needed for queue front and rear representation
	public static class Node {
		int value;
		Node next;
		public Node(int value) {
			this.value = value;
		}
	}
	
	//push node to the linked list as if this is a stack
	public void push(Node node){
		if(node != null) {
			node.next = head;
			head = node;
		}
	}
	
	//pop node from the linked list as if this is a stack
	public Node pop() {
		if(head == null)
			return null;
		else {
			Node node = new Node(head.value);
			head = head.next;
			return node;
		}
	}
	
	//peek node from the linked list as if this is a stack
	public Node peek() {
		if(head != null) {
			return head;
		}
		return null;
	}
	
	//enqueue node to the linked list as if this is a queue
	public void enqueue(Node node) {
		if(front == null) {
			front = node;
			rear = node;
		} else {
			rear.next = node;
			rear = node;
		}
	}
	
	//dequeue node from the linked list as if this is a queue
	public Node dequeue() {
		if(front == null) {
			return null;
		} else {
			Node node = new Node(front.value);
			front = front.next;
			return node;
		}
	}
	
	//display the value of queue
	public void printQueue() {
		Node temp = front;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	//display the value of stack
	public void printStack() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackAndQueueImpl obj = new StackAndQueueImpl();
		//queue
		System.out.println("-----start queue-----");
		obj.enqueue(new Node(1));
		obj.enqueue(new Node(2));
		obj.enqueue(new Node(3));
		System.out.println("After enqueue :");
		obj.printQueue();
		System.out.println("Value dequed -> "+obj.dequeue().value);
		System.out.println("After dequeue :");
		obj.printQueue();
		System.out.println("-----end queue-----\n");
		//stack
		System.out.println("-----start stack-----");
		obj.push(new Node(10));
		obj.push(new Node(11));
		obj.push(new Node(12));
		System.out.println("After push :");
		obj.printStack();
		System.out.println("Peek -> "+obj.peek().value);
		System.out.println("Pop -> "+obj.pop().value);
		System.out.println("After pop :");
		obj.printStack();
		System.out.println("-----end stack-----");
	}

}
