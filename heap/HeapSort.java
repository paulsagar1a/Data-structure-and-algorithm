/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category heap
 *******************************************************/

//Heap sort algorithm

package heap;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 11, 8, 5, 7, 10};
		HeapSort obj = new HeapSort();
		obj.sort(arr);
		obj.printSortedArray(arr);
	}

	private void printSortedArray(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
        for (int i=0; i < n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
	}

	private void sort(int[] arr) {
		// TODO Auto-generated method stub
		int n = arr.length;
		
		//build max heap
		for(int i=n/2-1; i>=0; i--) {
			heapify(arr, n, i);
		}
		
		// Heap sort
        for (int i=n-1; i>=0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
          	// Heapify root element
            heapify(arr, i, 0);
        }
	}

	private void heapify(int[] arr, int n, int i) {
		// TODO Auto-generated method stub
		//find largest among root, left child and right child
		int largest = i;
		int l = 2*i + 1;
		int r = 2*i + 2;  
		 
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
      	// Swap and continue heapifying if root is not largest
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapify(arr, n, largest);
        }
	}

}
