class Solution {
    public int findLHS(int[] nums) {
        /*
            two pointers
        */
        if (nums.length < 2) return 0;
        int fast = 0;
        int slow = 0;
        int max = 0;
        Arrays.sort(nums);
        int count = 0;
        int temp = Integer.MIN_VALUE;
        int tempCount = 0;
        while (fast < nums.length) {
            if (nums[fast] - nums[slow] > 1) {
                slow++;
                count--;
            } else if (nums[fast] - nums[slow] == 1) {
                if (temp + 1 == nums[fast]) {
                    count += tempCount;
                }
                tempCount = 0;
                temp = 0;
                fast++;
                count++;
            } else if (nums[fast] - nums[slow] == 0) {
                tempCount++;
                temp = nums[slow];
                fast++;
            }
            max = Math.max(max, count);
        }
        
        return max;
    }
}