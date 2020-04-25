class Solution {
    public int pivotIndex(int[] nums) {
        /*
            Algorithm explained:
                create two int array to keep track of all left and right sums of a given point
                check if their values are equal at some point
                that point is the pivot point
        */
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        
        for (int i = nums.length - 2; i >= 0; --i) {
            rightSum[i] = nums[i + 1] + rightSum[i + 1];
        }
        
        
        for (int i = 1; i < nums.length; ++i) {
            leftSum[i] = nums[i - 1] + leftSum[i - 1];
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum[i] == rightSum[i]) {
                return i;
            }
        }
        
        return -1;
    }
}