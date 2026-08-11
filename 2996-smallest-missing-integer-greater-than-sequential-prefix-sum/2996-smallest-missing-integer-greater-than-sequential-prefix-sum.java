class Solution {
    public int missingInteger(int[] nums) {

        int sum = nums[0];

        // Find sum of longest sequential prefix
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        int candidate = sum;

        // Keep checking until candidate is missing
        while (true) {

            boolean found = false;

            for (int i = 0; i < nums.length; i++) {

                if (nums[i] == candidate) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return candidate;
            }

            candidate++;
        }
    }
}