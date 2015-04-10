package week12;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
    	if(prices.length < 2) return 0;
		int min = prices[0];
		int ans = 0;
		for (int i = 1; i < prices.length; i++) {
			if( prices[i] < min ) min = prices[i];
			ans = ans > (prices[i]-min)? ans :(prices[i]-min);
		}
    	return ans;
    }
}
