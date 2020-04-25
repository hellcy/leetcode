class Solution {
    public double findMaxAverage(int[] nums, int k) {
        /*
            Algorithm explained:
                create a new array, each value is the sum of the k-length subarray start of current position
        */
        int[] array = new int[nums.length + 1];
        
        array[0] = 0;
        double max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; ++i) {
            if (i < k) {
                array[i + 1] = array[i] + nums[i];
                if (i == k - 1) max = array[i + 1];
            } else {
                array[i + 1] = array[i] + nums[i] - nums[i - k];
                max = Math.max(max, array[i + 1]);
            }
        }
        
        return max / k;
    }
}