class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return solve(0,dp,nums);
        
    }
    int solve(int i, int[] dp, int[] nums){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int take = nums[i] + solve(i+2, dp,nums);
        int nottake = 0 + solve(i+1,dp,nums);
        dp[i] = Math.max(take,nottake);

        return dp[i];
    }
}