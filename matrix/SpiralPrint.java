/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category matrix
 *******************************************************/

/*Print a given matrix in spiral form*/

package matrix;

public class SpiralPrint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 4;
		int col = 5;
		int[][] matrix = {
				{10, 20, 30, 40, 50},
				{45, 55, 65, 75, 85},
				{21, 31, 41, 51, 61},
				{11, 22, 33, 44, 55}
		};
		SpiralPrint obj = new SpiralPrint();
		obj.printSpiral(matrix, row, col);
	}

	private void printSpiral(int[][] matrix, int row, int col) {
		int rowStart = 0, rowEnd = matrix.length - 1;
		int colStart = 0, colEnd = matrix[0].length - 1;
		
		while(rowStart <= rowEnd && colStart <= colEnd) {
			for(int i=rowStart; i<=colEnd; i++) {
				System.out.print(matrix[rowStart][i]+" ");
			}
			for(int i=rowStart+1; i<=rowEnd; i++) {
				System.out.print(matrix[i][colEnd]+" ");
			}
			if(rowStart+1 <= rowEnd) {
				for(int i=colEnd-1; i>= colStart; i--) {
					System.out.print(matrix[rowEnd][i]+" ");
				}
			}
			if(colStart+1 <= colEnd) {
				for(int i=rowEnd-1; i>rowStart; i--) {
					System.out.print(matrix[i][colStart]+" ");
				}
			}
			rowStart++;
			rowEnd--;
			colStart++;
			colEnd--;
		}
	}

}
