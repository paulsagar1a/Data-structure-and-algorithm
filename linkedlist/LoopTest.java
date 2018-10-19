package linkedlist;

/* Test if a linked list has loop
In this example we will see how to create a circular linked list,
how to detect the circle/loop, how to find the starting of the loop and
how to remove the loop of the linked list*/
public class LoopTest {
	public Node head;
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//add node to the linked list
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
	
	//create the loop
	public void createCircle(int position) {
		Node temp1 = head;
		while(temp1.next != null) {
			temp1 = temp1.next;
		}
		//check for the position where temp1.next will going to meet
		int i = 0;
		Node temp2 = head;
		while(i <= position) {
			temp2 = temp2.next;
			i++;
		}
		temp1.next = temp2;
	}
	
	//display the data
	public void print(int num) {
		Node temp = head;
		int i = 0;
		while(i < num && temp !=null) {
			System.out.println(temp.data);
			temp = temp.next;
			i++;
		}
	}
	
	//check the linked list is circular or not
	//Floyd’s Cycle-Finding Algorithm
	public boolean detectLoop() {
		Node temp1 = head;
		Node temp2 = head;
		while(temp1 != null && temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			if(temp1 == temp2) {
				return true;
			}
		}
		return false;
	}

	//find starting node of the circle
	public Node findStartingNode() {
		/*To find the starting of the loop first we need to find the point where
		the two nodes(i.e. temp1 and temp2) met.Then start one node from the head and
		another from the meeting point and step forward both nodes by node->next. 
		When both the nodes will meet in a certain point, that would be the 
		starting of the loop*/
		//find the meeting point of two nodes for detecting the loop
		Node temp1 = head;
		Node temp2 = head;
		while(temp1 != null && temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			if(temp1 == temp2) {
				break;//say meeting point is temp2
			}
		}
		//start temp1 from the head again
		temp1 = head;
		//find the starting point of the loop
		while(temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
	}
	
	//detach the loop
	public void detachLoop() {
		/*almost same as findStartingNode() 
		but in the last we will provide condition in while loop as
		temp1->next != temp2->next. And finally will make temp2->next = null*/
		Node temp1 = head;
		Node temp2 = head;
		while(temp1 != null && temp2 != null && temp2.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
			if(temp1 == temp2) {
				break;
			}
		}
		temp1 = head;
		while(temp1.next != temp2.next) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		temp2.next = null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoopTest obj = new LoopTest();
		obj.addNode(new Node(1));
		obj.addNode(new Node(2));
		obj.addNode(new Node(3));
		obj.addNode(new Node(4));
		obj.addNode(new Node(5));
		obj.createCircle(1);
		obj.print(10);
		System.out.println(obj.detectLoop());
		System.out.println(obj.findStartingNode().data); //3
		obj.detachLoop();
		obj.print(10);//1,2,3,4,5
	}

}
