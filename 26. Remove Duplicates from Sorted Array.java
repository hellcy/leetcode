class Solution {
    public int removeDuplicates(int[] nums) {
        /*
            create two pointers: fast and slow
            whenever fast meet a number that is different to slow, assign that value to slow's next position
            increment slow
        */
        if (nums.length <= 1) return nums.length;
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        
        return slow + 1;
    }
}