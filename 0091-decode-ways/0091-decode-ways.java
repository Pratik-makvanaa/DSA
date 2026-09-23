class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    int solve(int i, String s, int[] dp) {

        // Successfully decoded entire string
        if (i == s.length()) {
            return 1;
        }

        // Current digit is 0
        if (s.charAt(i) == '0') {
            return 0;
        }

        // Already calculated
        if (dp[i] != -1) {
            return dp[i];
        }

        // Choice 1: Take one digit
        int one = solve(i + 1, s, dp);

        // Choice 2: Take two digits
        int two = 0;

        if (i + 1 < s.length()) {

            int number = Integer.parseInt(
                s.substring(i, i + 2)
            );

            if (number >= 10 && number <= 26) {
                two = solve(i + 2, s, dp);
            }
        }

        dp[i] = one + two;

        return dp[i];
    }
}