class Solution {
    public int numDecodings(String s) {

        int n = s.length();

        int[] dp = new int[n + 1];

        // Base case:
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            // Current digit 0 hai
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            // Take one digit
            dp[i] = dp[i + 1];

            // Take two digits
            if (i + 1 < n) {

                int number = Integer.parseInt(
                    s.substring(i, i + 2)
                );

                if (number >= 10 && number <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}