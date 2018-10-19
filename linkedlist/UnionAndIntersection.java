package linkedlist;

import java.util.HashSet;
import java.util.Set;

/*Union and Intersection of two Linked Lists
Given two Linked Lists, create union and intersection lists that 
contain union and intersection of the elements present in the given lists.
Order of elements in output lists doesn’t matter*/

public class UnionAndIntersection {
	/*Solution:
	 * 	1. Remove duplicates of the two list(note-
	 * in case of Intersection duplicate values can come twice)
	 * but here for better understanding I am removing the duplicates
	 * of each list
	 * 	2. Sort both the list(use merge sort because time complexity
	 * of merge sort is O(nlogn))
	 * 	3. Follow the steps:
	 * 		Union:
	 * 			a) create a new list, say newList
	 * 			b) run a loop: list1->next != null
	 * 				if [list1->data < list2->data]
	 * 					add list1->data to the newList
	 * 					list1 = list1->next
	 * 				else if [list2->data < list2->data]
	 * 					add list2->data to the newList
	 * 					list2 = list2->next
	 * 				else //when [list1->data = list2->data]
	 * 					list1 = list1->next and
	 * 					list2 = list2->next
	 * 			c) In case any of the two list list->next not null i.e.
	 * 				if [list1->next != null] OR [list2->next != null]
	 * 				run a loop list->next != null
	 * 				add list->data to the newList
	 * 
	 * 		Intersection:
	 * 			a) create a new list, say newList
	 * 			b) run a loop: list1->next != null
	 * 				if [list1->data < list2->data]
	 * 					list1 = list1->next
	 * 				else if [list2->data < list2->data]
	 * 					list2 = list2->next
	 * 				else //when [list1->data = list2->data]
	 * 					add list1->data to the newList
	 * 					list1 = list1->next and
	 * 					list2 = list2->next
	 * 				
	 * Time complexity of the 3rd step: O(m+n)
	 * */
	//Overall time complexity = O(max(nlogn, mlogm))
	
	public Node head1;
	public Node head2;
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//add node to the first linked list
	public void addToFirstLinkedList(Node node) {
		if(head1 == null) {
			head1 = node;
		} else {
			Node temp = head1;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	//add node to the second linked list
	public void addToSecondLinkedList(Node node) {
		if(head2 == null) {
			head2 = node;
		} else {
			Node temp = head2;
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
	}
	
	//print the list
	public void print(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	//remove the duplicates from first linked list
	public void removeDuplicateFromFirstList() {
		Set<Integer> set = new HashSet<>();
		Node current = head1;
		Node previous = null;
		while(current != null) {
			//if current value is already in the set
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		print(head1);
	}
	
	//remove the duplicates from second linked list
	public void removeDuplicateFromSecondList() {
		Set<Integer> set = new HashSet<>();
		Node current = head2;
		Node previous = null;
		while(current != null) {
			//if current value is already in the set
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = current.next;
		}
		print(head2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnionAndIntersection obj1 = new UnionAndIntersection();
		UnionAndIntersection obj2 = new UnionAndIntersection();
		
		obj1.addToFirstLinkedList(new Node(1));
		obj1.addToFirstLinkedList(new Node(3));
		obj1.addToFirstLinkedList(new Node(2));
		obj1.addToFirstLinkedList(new Node(5));
		obj1.addToFirstLinkedList(new Node(4));
		
		obj2.addToSecondLinkedList(new Node(2));
		obj2.addToSecondLinkedList(new Node(2));
		obj2.addToSecondLinkedList(new Node(4));
		obj2.addToSecondLinkedList(new Node(5));
		obj2.addToSecondLinkedList(new Node(1));
		obj2.addToSecondLinkedList(new Node(6));
		obj2.addToSecondLinkedList(new Node(6));
		obj1.removeDuplicateFromFirstList();
		obj2.removeDuplicateFromSecondList();
	}

}
