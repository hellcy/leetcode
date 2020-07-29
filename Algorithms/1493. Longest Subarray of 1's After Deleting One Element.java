class Solution {
    public int longestSubarray(int[] nums) {
        /*
            two pointers
            find the longest subarray with only one zero in it
        */
        
        int index = 0;
        int zero = 0;
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (index <= nums.length && zero <= 1) {
                max = Math.max(max, index - i);
                if (index == nums.length) return max - 1;
                if (nums[index] == 0) {
                    zero++;
                }
                index++;
                //System.out.println(index + " " + max);
            }
            
            if (zero > 1) {
                if (nums[i] == 0) {
                    zero--;
                }
            }
        }
        
        return max - 1;
    }
}