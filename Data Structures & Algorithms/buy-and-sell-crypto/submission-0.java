class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0], profit = 0;

        for(int i=0; i<prices.length; i++) {
            low = Math.min(low, prices[i]);
            profit = Math.max(profit, prices[i]-low);
        }

        return profit;
    }
}
