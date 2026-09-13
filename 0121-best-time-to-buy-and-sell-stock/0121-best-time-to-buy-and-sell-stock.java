class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxiProfit = 0;

        for(int i=1;i<prices.length;i++){
                int profit = prices[i] - minPrice;
                maxiProfit = Math.max(maxiProfit, profit);
                minPrice = Math.min(minPrice, prices[i]);
            }
        return maxiProfit;
    }
}