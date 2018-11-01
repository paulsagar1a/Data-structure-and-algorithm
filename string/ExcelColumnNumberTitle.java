/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 * 
 * Find Excel column name from a given column number &
 * Find Excel column number from column title
 *******************************************************/
package string;

public class ExcelColumnNumberTitle {

	public String toTitle(int number) {
		StringBuilder title = new StringBuilder();
		while(number-- > 0) {
			title.append((char)('A' + (number%26)));
			number = number/26;
		}
		return title.reverse().toString();
	}
	
	public int toNumber(String title) {
		int number = 0;
		for(int i=0; i< title.length(); i++) {
			number = number * 26 + (title.charAt(i) - ('A' - 1));
		}
		return number;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelColumnNumberTitle obj = new ExcelColumnNumberTitle();
		
		System.out.println("Excel column Number to title:");
		System.out.println(obj.toTitle(26));
		System.out.println(obj.toTitle(16900));
		System.out.println(obj.toTitle(705));
		System.out.println(obj.toTitle(676));
		System.out.println(obj.toTitle(702));
		System.out.println(obj.toTitle(1000));
		
		System.out.println("Excel column Title to number:");
		System.out.println(obj.toNumber("ZZ"));
		System.out.println(obj.toNumber("YX"));
		System.out.println(obj.toNumber("AAC"));
		System.out.println(obj.toNumber("XYZ"));
		System.out.println(obj.toNumber("ALL"));
	}

}
