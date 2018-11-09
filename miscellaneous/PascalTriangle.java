/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/
//print pascal's triangle
package miscellaneous;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPascalTriangle(5);
		printPascalMatrix(7);
	}

	private static void printPascalTriangle(int row) {
		// TODO Auto-generated method stub
		for(int i=0; i<row; i++) {
			int num = 1;
			System.out.printf("%" + (row-i)*2 + "s", "");
			for(int j=0; j<=i; j++) {
				System.out.printf("%4d",num);
				num = num * (i-j)/(j+1);
			}
			System.out.println();
		}
	}
	
	private static void printPascalMatrix(int n) {
		// An auxiliary array to store  
		// generated pscal triangle values 
		int[][] arr = new int[n][n];  
		  
		// Iterate through every line and print integer(s) in it 
		for (int line = 0; line < n; line++) 
		{ 
		    // Every line has number of integers  
		    // equal to line number 
		    for (int i = 0; i <= line; i++) 
		    { 
		    // First and last values in every row are 1 
		    if (line == i || i == 0) 
		        arr[line][i] = 1; 
		    // Other values are sum of values just  
		    // above and left of above 
		    else 
		        arr[line][i] = arr[line-1][i-1] + arr[line-1][i]; 
		    System.out.printf("%d ", arr[line][i]); 
		    } 
		    System.out.print("\n"); 
		}
	}

}
