class Solution {
    /*
        two pointers
        triplets could be the same
        for pointer left and right, if nums[left] + nums[right] < value, all numbers left < x < right are also valid right index
        so we add (right - left) to the count
    */
    int count = 0;
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            //if (i > 0 && nums[i] == nums[i - 1]) continue;
            int value = target - nums[i];
            
            twosumhelper(nums, value, i + 1);
        }
        
        return count;
    }
    
    private void twosumhelper(int[] nums, int value, int start) {
        int left = start, right = nums.length - 1;
        
        while (left < right) {
            if (nums[left] + nums[right] < value) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
    }
}