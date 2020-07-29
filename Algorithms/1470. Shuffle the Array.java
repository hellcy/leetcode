class Solution {
    public int[] shuffle(int[] nums, int n) {
        int length = nums.length;
        int[] array1 = new int[length / 2];
        int[] array2 = new int[length / 2];
        
        for (int i = 0; i < array1.length; ++i) {
            array1[i] = nums[i];
            array2[i] = nums[array1.length + i];
        }
        
        for (int i = 0; i < length; i = i + 2) {
            nums[i] = array1[i / 2];
            nums[i + 1] = array2[i / 2];
        }
        
        return nums;
    }
}