class Solution {
    public int dominantIndex(int[] nums) {
        /*
            Algorithm explained:
                keep tracking the Max and Second Max numbers in the list
                return true if Max at least twice as much as the second Max
        */
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (max < nums[i]) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] < max && nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        if (max / 2 >= secondMax) return index;
        return -1;
        
    }
}