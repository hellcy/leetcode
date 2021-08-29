class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        
        int first = 0, second = k - 1;
        while (second < nums.length) {
            ans = Math.min(nums[second] - nums[first], ans);
            first++;
            second++;
        }
        
        return ans;
    }
}