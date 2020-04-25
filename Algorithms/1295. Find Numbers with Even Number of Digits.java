class Solution {
    public int findNumbers(int[] nums) {
        /*
            Array
        */
        int count = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (numberOfDigits(nums[i]) % 2 == 0) {
                count++;
            }
        }
        
        return count;
    }
    
    private int numberOfDigits(int n) {
        int count = 0;
        
        while (n >= 1) {
            n = n / 10;
            count++;
        }
        
        return count;
    }
}