class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,0,text1,text2,dp);
        
    }
    int solve(int i,int j, String text1, String text2,int[][] dp){

        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + solve(i+1,j+1,text1,text2, dp);
        }else{
            int take = solve(i+1,j,text1,text2,dp);
        int donttake = solve(i,j+1,text1,text2,dp);

        dp[i][j] = Math.max(take,donttake);
        }
    return dp[i][j];
    }
}