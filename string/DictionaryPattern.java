package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category String
 *******************************************************/

/*Find all strings that match specific pattern in a dictionary
Given a dictionary of words, find all strings that matches the 
given pattern where every character in the 
pattern is uniquely mapped to a character in the dictionary.*/
public class DictionaryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"HTH", "ACK", "LOL", "TQ", "TYT", "ROTFL"};
		String pattern = "AKA";
		Iterator<String> itr = findMatch(words, pattern).iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	private static List<String> findMatch(String[] words, String pattern) {
		// TODO Auto-generated method stub
		String encodedPattern = getEncodedPattern(pattern);
		List<String> list = new ArrayList<>();
		for(String word : words) {
			if(getEncodedPattern(word).equals(encodedPattern)) {
				list.add(word);
			}
		}
		return list;
	}

	private static String getEncodedPattern(String pattern) {
		// TODO Auto-generated method stub
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int counter = 0;
		for(Character ch : pattern.toCharArray()) {
			/*if(map.containsKey(ch)) {
				sb.append(map.get(ch));
			} else {
				counter ++;
				map.put(ch, counter);
				sb.append(counter);
			}*/
			if(!map.containsKey(ch)) {
				map.put(ch, counter++);
			}
			sb.append(map.get(ch));
		}
		return sb.toString();
	}

}
