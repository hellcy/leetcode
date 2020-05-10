class Solution {
    public int removeDuplicates(int[] nums) {
        /*
            Two pointers
            
        */
        boolean flag = false;
        
        int slow = 0, fast = 1;
        if (nums == null || nums.length == 0) return 0;
        
        while (slow < nums.length && fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                if (!flag) {
                    flag = true;
                    if (slow + 1 < fast) {
                        nums[slow + 1] = nums[fast];
                    }
                    slow++;
                }
                fast++;
            } else {
                nums[slow + 1] = nums[fast];
                slow++;
                fast++;
                flag = false;
            }
        }
        
        return slow + 1;
    }
}