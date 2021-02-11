class Solution {
    public boolean check(int[] nums) {
        boolean found = false;
        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i - 1]) {
                if (found) return false;
                else {
                    found = true;
                }
            }
        }

        if (!found) return true;
        if (nums[n - 1] <= nums[0]) return true;
        else return false;
    }
}