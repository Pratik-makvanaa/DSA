class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(0,1,prices,dp);
        
    }
    int solve(int i, int buy, int[] prices, int[][] dp){
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit;
        if(buy == 1){
            profit = Math.max(-prices[i] + solve(i+1,0,prices,dp),
                                0 + solve(i+1,1,prices,dp));
        }
        else{
            profit = Math.max(prices[i] + solve(i+1,1,prices,dp)
                                ,0 + solve(i+1,0,prices,dp));
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }

}