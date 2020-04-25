class Solution {
    public int removeElement(int[] nums, int val) {
        /*
            create two pointers: fast and slow
            when fast's value is target value, move to the next
            otherwise, assign it to slow, and increment both pointers
        */
        if (nums.length == 0) return 0;
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                fast++;
                slow++;
            } else {
                fast++;
            }
        }
        return slow;
    }
}