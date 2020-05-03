class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        /*
            two pointers
            if the distance between ones is less than k, return false
        */
        int length = nums.length;
        if (k <= 0) return true;
        int slow = 0, fast = 1;
        
        int dis = 0;
        while (slow < length && fast < length) {
            if (nums[slow] == 0) {
                slow++;
                fast = slow + 1;
            } else {
                if (slow != fast && nums[fast] == 0) {
                    dis++;
                    fast++;
                } else {
                    if (dis < k) return false;
                    slow = fast;
                    fast++;
                    dis = 0;
                }
            }
        }
        
        return true;
    }
}