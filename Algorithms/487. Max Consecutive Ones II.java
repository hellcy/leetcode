class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*
            Two pointers
            the question can be seen as:
            find the maximum subarray with only one 0 in it.
            
            Similar to question: 1248. Count Number of Nice Subarrays
        */
        int max = 0;
        int left = 0, right = 0;
        
        int zero = 0;
        while (right < nums.length) {
            while (right < nums.length && zero == 0) {
                if (nums[right] == 0) zero++;
                right++;
            }
            
            while (right < nums.length && nums[right] != 0) {
                right++;
            }
            max = Math.max(max, right - left);
            //System.out.println(max);
            while (left < right && zero != 0) {
                if (nums[left] == 0) zero--;
                left++;
            }
        }
        
        return max;
    }
}