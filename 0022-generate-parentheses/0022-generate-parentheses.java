class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        backtrack(n, 0, 0, "", ans);

        return ans;
    }

    public void backtrack(int n, int open, int close,
                          String current, List<String> ans) {

        // Complete valid combination
        if (open == n && close == n) {
            ans.add(current);
            return;
        }

        // Add '('
        if (open < n) {
            backtrack(n, open + 1, close,
                      current + "(", ans);
        }

        // Add ')'
        if (close < open) {
            backtrack(n, open, close + 1,
                      current + ")", ans);
        }
    }
}