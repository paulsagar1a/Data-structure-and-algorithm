package string;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/
/*Convert a roman number to a decimal number*/
public class RomanToDecimal {

	//get all the values of each roman number
	private int getDecimalValue(char ch) {
		if(ch == 'I') 
			return 1;
		if(ch == 'V')
			return 5;
		if(ch == 'X')
			return 10;
		if(ch == 'L')
			return 50;
		if(ch == 'C')
			return 100;
		if(ch == 'D')
			return 500;
		if(ch == 'M')
			return 1000;
		return -1;
	}
	
	//function that converts roman to decimal
	private int getDecimal(String roman) {
		int decimal = 0;
		int length = roman.length();
		for(int i=0; i<length; i++) {
			int num1 = getDecimalValue(roman.charAt(i));
			if(i+1 < length) {
				int num2 = getDecimalValue(roman.charAt(i+1));
				//if next roman number is greater than previous one
				//subtract the previous from the next
				if(num1 < num2) {
					decimal += num2 - num1;
					i++;
				} else { //only add the current number
					decimal += num1;
				}
			} else {
				decimal += num1;
				i++;
			}
		}
		return decimal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToDecimal obj = new RomanToDecimal();
		System.out.println(obj.getDecimal("DIX"));
	}

}
