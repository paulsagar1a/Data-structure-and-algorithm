/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category miscellaneous
 *******************************************************/

//PriorityQueue internal implementation

package stack_queue;

public class PriorityQueueImpl {

	private int[] queue;
	private int size;
	private int rear;
	private int front;
	
	private PriorityQueueImpl(int size) {
		this.size = size;
		this.queue = new int[this.size];
		this.rear = 0;
		this.front = -1;
	}
	
	private boolean isFull() {
		if(rear == size)
			return true;
		return false;
	}
	
	private boolean isEmpty() {
		if(rear == 0 || front == rear)
			return true;
		return false;
	}
	
	private void add(int value) {
		int i;
		if(isFull()) {
			try {
				throw new QueueOverFlowException("Can not insert "+value+" as queue is full.");
			} catch (QueueOverFlowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(rear == 0) {
			front++;
			queue[rear] = value;
			rear++;
		}	else {
			for(i=rear-1; i>=front; i--) {
				if(value > queue[i])
					queue[i+1] = queue[i];
				else
					break;
			}
			queue[++i] = value;
			rear++;
		}
	}
	
	private int poll() {
		if(isEmpty()) {
			try {
				throw new QueueUnderFlowException("Can not poll as queue is empty");
			} catch (QueueUnderFlowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queue[front++];
	}
	
	private int peek() {
		if(isEmpty()) {
			try {
				throw new QueueUnderFlowException("Can not peek as queue is empty");
			} catch (QueueUnderFlowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return queue[front];
	}
	
	private void printQueue() {
		System.out.println("PriorityQueue elements:");
		for(int i=rear-1; i>=front; i--)
			System.out.println(queue[i]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueueImpl pQueue = new PriorityQueueImpl(5);
		pQueue.add(2);
		pQueue.add(1);
		pQueue.add(4);
		pQueue.add(3);
		pQueue.add(5);
		System.out.println(pQueue.peek());
		System.out.println(pQueue.poll());
		pQueue.printQueue();
	}

	@SuppressWarnings("serial")
	public class QueueOverFlowException extends Exception {
		public QueueOverFlowException(String message) {
			super(message);
		}
	}
	
	@SuppressWarnings("serial")
	public class QueueUnderFlowException extends Exception {
		public QueueUnderFlowException(String message) {
			super(message);
		}
	}

}
