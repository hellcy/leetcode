class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        /*
            Sliding window
        */
        int ans = 0;
        int cur = 0;
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0;
        while (start < nums.length) {
            if (!set.contains(nums[start])) {
                set.add(nums[start]);
                cur += nums[start];
                ans = Math.max(ans, cur);
                start++;
            } else {
                set.remove(nums[end]);
                cur -= nums[end];
                end++;
            }
        }

        return ans;
    }
}