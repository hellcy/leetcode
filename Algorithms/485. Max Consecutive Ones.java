class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*
            Algorithm explained:
                keep track the number of consecutive ones and when meet zero, set count to zero
                also keep track the max so far
        */
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == 1) {
                count++;
            } else {
                if (max < count) {
                    max = count;   
                }
                count = 0;
            }
        }
        
        if (count != 0) {
            if (max < count) {
                max = count;   
            }
        }
        
        return max;
    }
}