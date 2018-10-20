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
	 * 			b) run a loop: list1->next != null && list2->next !=null
	 * 				if [list1->data < list2->data]
	 * 					add list1->data to the newList
	 * 					list1 = list1->next
	 * 				else if [list2->data < list2->data]
	 * 					add list2->data to the newList
	 * 					list2 = list2->next
	 * 				else //when [list1->data = list2->data]
	 * 					add list2->data to the newList
	 * 					list1 = list1->next and
	 * 					list2 = list2->next
	 * 			c) In case any of the two list list->next not null i.e.
	 * 				if [list1->next != null] OR [list2->next != null]
	 * 				run a loop list->next != null
	 * 				add list->data to the newList
	 * 
	 * 		Intersection:
	 * 			a) create a new list, say newList
	 * 			b) run a loop: list1->next != null && list2->next !=null
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
	
	public static Node head1;
	public static Node head2;
	public static class Node {
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	
	//display node data
	public static void print(Node node) {
		Node temp = node;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	//remove duplicates from the list
	public static void removeDuplicates(Node node) {
		Node current = node;
		Node previous = null;
		Set<Integer> set = new HashSet<>();
		
		while(current != null) {
			if(set.contains(current.data)) {
				previous.next = current.next;
			} else {
				set.add(current.data);
				previous = current;
			}
			current = previous.next;
		}
	}
	
	//sort the two linked list (merge sort)
	public static Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node middle = getMiddle(node);
		Node newList = middle.next;
		middle.next = null;
		//apply merge sort to the left and right list
		Node left = mergeSort(node);
		Node right = mergeSort(newList);
		//merge both the left and right list
		return merge(left, right);
	}
	
	//merge two list
	public static Node merge(Node left, Node right) {
		if(left == null)
			return right;
		if(right == null)
			return left;

		Node mergedNode = null;
		if(left.data <= right.data) {
			mergedNode = left;
			mergedNode.next = merge(left.next, right);
		} else {
			mergedNode = right;
			mergedNode.next = merge(left, right.next);
		}
		return mergedNode;
	}
	
	//get the middle of the node
	public static Node getMiddle(Node node) {
		Node temp1 = node;
		Node temp2 = node;
		while(temp2 != null && temp2.next != null && temp2.next.next != null) {
			temp1 = temp1.next;
			temp2 = temp2.next.next;
		}
		return temp1;
	}
	
	//get the union of two list
	public static Node getUnion(Node list1, Node list2) {
		if(list1 == null && list2 == null)
			return null;
		Node union = new Node(0);
		Node tempUnion = union;
		while(list1.next != null && list2.next != null) {
			if(list1.data < list2.data) {
				tempUnion.data = list1.data;
				list1 = list1.next;
			} else if(list2.data < list1.data) {
				tempUnion.data = list2.data;
				list2 = list2.next;
			} else {
				tempUnion.data = list2.data;
				list1 = list1.next;
				list2 = list2.next;
			}
			if(list1 != null && list2 != null)
				tempUnion = tempUnion.next = new Node(0);
		}
		if(list1.next != null) {
			while(list1 != null) {
				tempUnion.data = list1.data;
				list1 = list1.next;
				if(list1 != null)
					tempUnion = tempUnion.next = new Node(0);
			}
		}
		if(list2.next != null) {
			while(list2 != null) {
				tempUnion.data = list2.data;
				list2 = list2.next;
				if(list2 != null)
					tempUnion = tempUnion.next = new Node(0);
			}
		}
		return union;
	}
	
	//get the intersection of two lists
	public static Node getIntersection(Node list1, Node list2) {
		if(list1 == null && list2 == null)
			return null;
		Node intersection = null;
		Node tempIntersection = null;
		while(list1 != null && list2 != null) {
			if(list1.data < list2.data) {
				list1 = list1.next;
			} else if(list2.data < list1.data) {
				list2 = list2.next;
			} else {
				if(intersection == null) {
					intersection = new Node(0);
					tempIntersection = intersection;
				}
				else {
					tempIntersection = tempIntersection.next = new Node(0);
				}
				tempIntersection.data = list2.data;
				list1 = list1.next;
				list2 = list2.next;
			}
		}
		return intersection;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(5);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(3);
		head1.next.next.next.next.next = new Node(3);
		head2 = new Node(3);
		head2.next = new Node(8);
		head2.next.next = new Node(5);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(9);
		head2.next.next.next.next.next = new Node(3);
		head2.next.next.next.next.next.next = new Node(7);
		head2.next.next.next.next.next.next.next = new Node(6);
		
		System.out.println("----------initially head1----------");
		print(head1);
		System.out.println("----------initially head2----------");
		print(head2);
		//remove the duplicates of head1 and head2 list
		removeDuplicates(head1);
		removeDuplicates(head2);
		System.out.println("-----After removing the duplicates-----");
		System.out.println("----------head1----------");
		print(head1);
		System.out.println("----------head2----------");
		print(head2);
		//sort head1 and head2
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);
		System.out.println("-----After sorting-----");
		System.out.println("----------head1----------");
		print(head1);
		System.out.println("----------head2----------");
		print(head2);
		Node union = getUnion(head1, head2);
		System.out.println("----------Union----------");
		print(union);
		Node intersection = getIntersection(head1, head2);
		System.out.println("----------Intersection----------");
		print(intersection);
	}

}
