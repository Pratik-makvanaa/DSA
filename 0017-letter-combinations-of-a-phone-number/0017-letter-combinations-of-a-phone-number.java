class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0) {
            return ans;
        }

        String[] map = {
            "", "", "abc", "def",
            "ghi", "jkl", "mno",
            "pqrs", "tuv", "wxyz"
        };

        backtrack(0, digits, map, new StringBuilder(), ans);

        return ans;
    }

    private void backtrack(
            int index,
            String digits,
            String[] map,
            StringBuilder current,
            List<String> ans) {

        // Complete combination
        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        // Current digit
        int digit = digits.charAt(index) - '0';

        String letters = map[digit];

        // Try every letter
        for (char ch : letters.toCharArray()) {

            current.append(ch);

            backtrack(
                index + 1,
                digits,
                map,
                current,
                ans
            );

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }
}