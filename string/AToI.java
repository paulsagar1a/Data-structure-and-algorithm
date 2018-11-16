/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category string
 *******************************************************/
/*The atoi() function takes a string (which represents an integer) 
as an argument and returns its value.*/
package string;

public class AToI {

	public int atoi(String str) {
		if (str == null || str.length() < 1)
			return 0;
		//trim white space
		str = str.trim();
		char flag = '+';
		int i = 0;
		if (str.charAt(i) == '-') {
			flag = '-';
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		
		long result = 0;
		for(;i<str.length(); i++) {
			result = result*10 + (str.charAt(i) - '0');
		}
		
		if(flag == '-') {
			result = -result;
		}
		
		//handle MAX/MIN
		if(result > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(result < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int)result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AToI obj = new AToI();
		System.out.println(obj.atoi("-14657"));
	}

}
