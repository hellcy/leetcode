class Solution {
    public int minStartValue(int[] nums) {
        /*
            startValue has to be greater than the smallest sum the array can get by one
        */
        int sum = 0, min = Integer.MAX_VALUE;
        
        for (int i : nums) {
            sum += i;
            if (sum < min) {
                min = sum;
            }
        }
        
        if (min >= 1) return 1;
        else return 1 - min; 
    }
}