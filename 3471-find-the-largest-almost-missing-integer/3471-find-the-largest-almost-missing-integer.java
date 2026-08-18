class Solution {

    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // -----------------------------------------
        // CASE 1:
        // k == n
        // -----------------------------------------

        if (k == n) {

            int max = -1;

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }


        // -----------------------------------------
        // Frequency array
        // nums[i] <= 50
        // so size 51 is enough.
        // -----------------------------------------

        int[] freq = new int[51];

        for (int num : nums) {
            freq[num]++;
        }


        // -----------------------------------------
        // CASE 2:
        // k == 1
        // -----------------------------------------

        if (k == 1) {

            int answer = -1;

            for (int num : nums) {

                // Number appears in exactly
                // one subarray of size 1.
                if (freq[num] == 1) {

                    answer =
                        Math.max(answer, num);
                }
            }

            return answer;
        }


        // -----------------------------------------
        // CASE 3:
        // 1 < k < n
        //
        // Only first and last elements
        // can be almost missing.
        // -----------------------------------------

        int answer = -1;


        // Check first element
        if (freq[nums[0]] == 1) {

            answer =
                Math.max(answer, nums[0]);
        }


        // Check last element
        if (freq[nums[n - 1]] == 1) {

            answer =
                Math.max(answer, nums[n - 1]);
        }


        return answer;
    }
}