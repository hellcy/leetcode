class Solution {
    public int missingNumber(int[] nums) {
        /*
            Algorithm explained:
                add all numbers to a set first,
                then check through the set and see if any number is missing by using i from 0 to n - 1
                if loop to the end, then the final number n is missing, return nums.length
        */
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }
}