class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        /*
            two pointers
        */
        int n = nums.length;
        int count = 0;
        
        int index = 0;
        int product = 1;
        for (int i = 0; i < n; ++i) {
            while (index < n && product < k) {
                product *= nums[index];
                index++;
                if (product < k) count += index - i;
                //System.out.println(count);
            }
            
            if (product >= k) {
                product /= nums[i];
                if (product < k) count += index - i - 1;
                //System.out.println(count);
            }
        }

        
        return count;
    }
}