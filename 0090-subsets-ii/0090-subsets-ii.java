import java.util.*;

class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        // Duplicates ko adjacent lane ke liye sort karo
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        solve(0, nums, current, ans);

        return ans;
    }

    void solve(
        int start,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> ans
    ) {

        // Current subset ko answer me add karo
        ans.add(new ArrayList<>(current));

        // Har possible element ko choose karke dekho
        for (int i = start; i < nums.length; i++) {

            // Same level par duplicate element skip karo
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Next elements ke liye recursion
            solve(i + 1, nums, current, ans);

            // Backtrack / Undo
            current.remove(current.size() - 1);
        }
    }
}