class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        /*
            brute force
            O(n^2) time
        */
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < nums.length; ++i) {
//             int sum = 0;
//             for (int j = i; j < nums.length; ++j) {
//                 sum += nums[j];
//                 if (sum >= s) {
//                     min = Math.min(min, j - i + 1);
//                 }
//             }
//         }
        
//         if (min == Integer.MAX_VALUE) return 0;
//         return min;
        
        /*
            better brute force
            O(n^2) time
            when we found a subarray with start and end index i and j, such that sum is already greater than s, we don't need to continue, because later subarray is not the best answer(longer length)
        */
//         int min = Integer.MAX_VALUE;
//         for (int i = 0; i < nums.length; ++i) {
//             int sum = 0;
//             for (int j = i; j < nums.length; ++j) {
//                 sum += nums[j];
//                 if (sum >= s) {
//                     min = Math.min(min, j - i + 1);
//                     break;
//                 }
//             }
//         }
        
//         if (min == Integer.MAX_VALUE) return 0;
//         return min;
        
        /*
            1. 当我们从i加到j>=s时，我们不需要继续让j++，因为那样subarray会更长。所以直接break
            2. 当我们把i++时，所有上一个j之前的j不用再加一遍，因为i++会让subarray变短，所以更加不会让sum>=s
            3. 所以保留一个prevj，每次从这里继续往后就可以了
            4. 当j算到最后也没有>=s,我们就可以让i等与length以跳出loop，因为i++也不会有更多答案
            
        */
        
//         int min = Integer.MAX_VALUE;
//         int prevj = 0;
        
//         int sum = 0;

//         for (int i = 0; i < nums.length; ++i) {
//             if (i > 0) sum -= nums[i - 1];
//             for (int j = prevj; j < nums.length; ++j) {
//                 sum += nums[j];
//                 if (sum >= s) {
//                     min = Math.min(min, j - i + 1);
//                     prevj = j;
//                     sum -= nums[prevj];
//                     break;
//                 }
//                 if (j == nums.length - 1) i = nums.length; 

//             }
//         }
        
//         if (min == Integer.MAX_VALUE) return 0;
//         return min;
        
        /*
            this is the same as method 3, with improved code template
        */
        int sum = 0;
        int min = Integer.MAX_VALUE;
        
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            }
            if (sum >= s) {
                min = Math.min(min, j - i);
            }
            sum -= nums[i];
        }
        
        if (min == Integer.MAX_VALUE) return 0;
        return min;
    }
}