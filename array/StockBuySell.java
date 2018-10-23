package array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category Array
 *******************************************************/

/*Stock Buy Sell to Maximize Profit
The cost of a stock on each day is given in an array, 
find the max profit that you can make by buying and 
selling in those days. For example, if the given array 
is {100, 180, 260, 310, 40, 535, 695}, the maximum profit 
can earned by buying on day 0, selling on day 3. Again buy 
on day 4 and sell on day 6. If the given array of prices is 
sorted in decreasing order, then profit cannot be earned at all.*/
public class StockBuySell {

	public static class Stock {
		int buy;
		int sell;
		Stock(int buy, int sell) {
			this.buy = buy;
			this.sell = sell;
		}
		@Override
		public String toString() {
			return "buy-> "+this.buy+" & sell-> "+this.sell;
		}
	}
	
	private static List<Stock> stockProfitStrategy(int[] stockArray) {
		// TODO Auto-generated method stub
		List<Stock> list = new ArrayList<>();
		int len = stockArray.length;
		int i = 0;
		while(i < len) {
			//find minima
			while(i+1 < len && stockArray[i+1] <= stockArray[i])
				i++;
			if(i == len-1) {
				break;
			}
			int buy = i;
			//find maxima
			while(i+1 < len && stockArray[i+1] > stockArray[i]) {
				i++;
			}
			int sell = i;
			list.add(new Stock(buy, sell));
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stockArray = {70,80,120,60,50,100,110};
		Iterator<Stock> itr = stockProfitStrategy(stockArray).iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
