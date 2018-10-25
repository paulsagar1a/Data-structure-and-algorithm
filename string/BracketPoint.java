package string;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/

/*Java program to find an index k which
decides the number of opening brackets
is equal to the number of closing brackets*/
/*Explanation:
index -->	 0 1 2 3 4 5 6 7 8 9
string-->	 ) ( ( ) ( ) ) ) ( )
left  -->	 0 0 1 2 2 3 3 3 3 4 4
right -->	 6 5 5 5 4 4 3 2 1 1 0
at index->6 left side '(' == right side ')'*/
public class BracketPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = ")(()()))()";
		System.out.println(findPoint(str));
	}

	private static int findPoint(String str) {
		// TODO Auto-generated method stub
		int len = str.length();
		int[] left = new int[len+1];
		int[] right = new int[len+1];
		left[0] = 0;
		right[len] = 0;
		if(str.charAt(0) == '(') {
			left[1] = 1;
		}
		if(str.charAt(len-1) == ')') {
			right[len-1] = 1;
		}
		for(int i=1; i<len; i++) {
			if(str.charAt(i) == '(')
				left[i+1] = left[i] + 1;
			else
				left[i+1] = left[i];
		}
		for(int i=len-2; i>=0; i--) {
			if(str.charAt(i) == ')')
				right[i] = right[i+1] + 1;
			else
				right[i] = right[i+1];
		}
		if(left[len] == 0)
			return -1;
		if(right[0] == 0)
			return -1;
		for(int i=0; i<=len; i++) {
			if(left[i] == right[i])
				return i;
		}
		return -1;
	}

}
