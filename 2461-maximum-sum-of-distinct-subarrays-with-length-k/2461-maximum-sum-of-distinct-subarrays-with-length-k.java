class Solution {

    public long maximumSubarraySum(int[] nums, int k) {

        int n = nums.length;
        long maxSum = 0;

        HashSet<Integer> set = new HashSet<>();

        int l = 0;
        long sum = 0;

        for (int r = 0; r < n; r++) {

            // duplicate hai toh left se elements hatao
            while (set.contains(nums[r])) {
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }

            // current element add karo
            set.add(nums[r]);
            sum += nums[r];

            // window size k ho gayi
            if (r - l + 1 == k) {

                maxSum = Math.max(maxSum, sum);

                // next window ke liye left element hatao
                set.remove(nums[l]);
                sum -= nums[l];
                l++;
            }
        }

        return maxSum;
    }
}