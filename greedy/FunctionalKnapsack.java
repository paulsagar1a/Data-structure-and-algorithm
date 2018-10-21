package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FunctionalKnapsack {

	private float getMaxProfit(int[] weights, int[] values, int capacity) {
		// TODO Auto-generated method stub
		//get the ratio of each item and add them to an array
		int length = weights.length;
		Items[] items = new Items[length];
		float ratio = 0;
		for(int i=0; i<length; i++) {
			ratio = (float)(values[i])/weights[i];
			items[i] = new Items(weights[i], values[i], ratio);
		}
		
		//sort the array in descending order of ratio
		Arrays.sort(items, new Comparator<Items>() {
			@Override
			public int compare(Items item1, Items item2) {
				if(item1.ratio < item2.ratio) return 1;
				if(item1.ratio > item2.ratio) return -1;
				return 0;
			}
		});
		
		//find max profit
		float maxProfit = 0;
		int currentWt = 0;
		for(Items item : items) {
			System.out.println(item);
			if(item.weight + currentWt <= capacity) {
				currentWt += item.weight;
				maxProfit += item.value;
			} else {
				maxProfit += (capacity - currentWt) * item.ratio;
				break;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalKnapsack obj = new FunctionalKnapsack();
		int[] weights = {6, 10, 3, 5, 1, 3};
		int[] values = {6, 2, 1, 8, 3, 5};
		int capacity = 16;
		System.out.println("Maximum Profit = "+obj.getMaxProfit(weights, values, capacity));
	}

}

class Items {
	int weight;
	int value;
	float ratio; //ratio = value/weight
	Items(int weight, int value, float ratio) {
		this.weight = weight;
		this.value = value;
		this.ratio = ratio;
	}
	
	@Override
	public String toString() {
		return "weight: "+this.weight+" value: "+this.value+" ratio:"+this.ratio;
	}
}
