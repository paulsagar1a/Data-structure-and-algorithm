package miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class PetrolPumpsTour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> petrol = new ArrayList<>();
		petrol.add(4);
		petrol.add(6);
		petrol.add(7);
		petrol.add(4);
		List<Integer> distance = new ArrayList<>();
		distance.add(6);
		distance.add(5);
		distance.add(3);
		distance.add(5);
		int start = findStartingPump(petrol, distance);
		System.out.println("Start= "+start);
	}

	private static int findStartingPump(List<Integer> petrol, List<Integer> distance) {
		// TODO Auto-generated method stub
		int start = 0;
		int totalPetrol = 0;
		int totalDistance = 0;
		int currentDistance = 0;
		
		for(int i=0; i<distance.size(); i++) {
			totalDistance += distance.get(i);
			totalPetrol += petrol.get(i);
			currentDistance += petrol.get(i) - distance.get(i);
			if(currentDistance < 0) {
				start = i+1;
				currentDistance = 0;
			}
		}
		
		if(totalDistance > totalPetrol)
			return -1;
		return start;
	}

}
