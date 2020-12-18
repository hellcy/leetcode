class Solution {
    public boolean increasingTriplet(int[] nums) {
        /*
            try to find 3 smallest numbers
        */
        
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE, third = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            if (num < first) {
                first = num;
            } else if (num > first && num < second) {
                second = num;
            } else if (num > second && num < third) {
                third = num;
            }
        }
        
        if (third != Integer.MAX_VALUE) return true;
        else return false;
    }
}