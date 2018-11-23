/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category sort
 *******************************************************/

//implement quick sort

package sort;

public class Quicksort {
    
   private int array[];
   private int length;

   public void sort(int[] inputArr) {
        
       if (inputArr == null || inputArr.length == 0) {
           return;
       }
       this.array = inputArr;
       length = inputArr.length;
       quickSort(0, length - 1);
   }

   private void quickSort(int lo, int hi) {
        
       int i = lo;
       int j = hi;
       // calculate pivot number, I am taking pivot as middle index number
       int pivot = array[lo+(hi-lo)/2];
       // Divide into two arrays
       while (i <= j) {
           while (array[i] < pivot) {
               i++;
           }
           while (array[j] > pivot) {
               j--;
           }
           if (i <= j) {
        	   int temp = array[i];
               array[i] = array[j];
               array[j] = temp;
               //move index to next position on both sides
               i++;
               j--;
           }
       }
       // call quickSort() method recursively
       if (lo < j)
           quickSort(lo, j);
       if (i < hi)
           quickSort(i, hi);
   }
    
   public static void main(String a[]){
        
       Quicksort sorter = new Quicksort();
       int[] input = {24,2,45,20,56,75,2,56,99,53,12};
       sorter.sort(input);
       for(int i:input){
           System.out.print(i);
           System.out.print(" ");
       }
   }
}