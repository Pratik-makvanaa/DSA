import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        solve(1, k, n, 0, current, ans);

        return ans;
    }

    void solve(int start, int k, int target,
               int sum, List<Integer> current,
               List<List<Integer>> ans) {

        // Exactly k numbers choose ho gaye
        if (current.size() == k) {

            // Check sum
            if (sum == target) {
                ans.add(new ArrayList<>(current));
            }

            return;
        }

        // Numbers sirf 1 to 9
        for (int i = start; i <= 9; i++) {

            // Sum target se exceed ho raha hai
            if (sum + i > target) {
                break;
            }

            // TAKE
            current.add(i);

            // i + 1 because same number dobara use nahi kar sakte
            solve(i + 1, k, target,
                  sum + i, current, ans);

            // BACKTRACK
            current.remove(current.size() - 1);
        }
    }
}