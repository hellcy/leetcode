class Solution {
    public void sortColors(int[] nums) {
        /*
            three pointers
            1. i pointer only moves when find ones and zeros, if it finds two, it will swap it with right.
            2. so left pointer will never find two.
            3. so when i pointer finds zero, after swap it with left pointer, they can both move to right by 1
        */
        if (nums == null || nums.length == 0) return;
        
        int left = 0, right = nums.length - 1, i = 0;
        
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) i++;
            else {
                swap(nums, right, i);
                right--;
            }
        }
    }
    
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    } 
}