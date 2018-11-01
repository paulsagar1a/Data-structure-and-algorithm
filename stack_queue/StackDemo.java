/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category stack_queue
 * 
 * Java Program to Implement Stack
 *******************************************************/
package stack_queue;

public class StackDemo {

	private int[] arr;
	private int size = -1;
	private int capacity;
	private StackDemo(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	private boolean isEmpty() {
		if(size == -1)
			return true;
		return false;
	}
	
	private boolean isFull() {
		if(size == capacity-1)
			return true;
		return false;
	}
	
	private void push(int item) {
		if(isFull()) {
			System.out.println("---> Stack is full. Can not add "+item);
			return;
		}
		size++;
		arr[size] = item;
	}
	
	private int pop() {
		if(isEmpty()) {
			System.out.println("---> Stack is Empty");
			return -1;
		}
		return arr[size--];
	}
	
	private void print() {
		for(int i=0; i <= size; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackDemo obj = new StackDemo(5);
		obj.push(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		obj.push(6);
		obj.print();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();
		obj.print();
		obj.push(6);
		obj.push(5);
		obj.print();
	}

}
