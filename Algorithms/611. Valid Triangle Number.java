class Solution {
    public int triangleNumber(int[] nums) {
        /*
            Array
            Brute force
            O(n^3) time
        */
//         Arrays.sort(nums);
//         int length = nums.length;
//         int count = 0;
//         for (int i = 0; i < length; ++i) {
//             for (int j = i + 1; j < length; ++j) {
//                 for (int k = j + 1; k < length; ++k) {
//                     if (nums[k] >= nums[i] + nums[j]) break;
//                     else count++;
//                 }
//             }
//         }
        
//         return count;
        
        /*
            when a <= b <= c
            triangle is valid when a + b > c
            
            for loop c and check how many pair of numbers are greater than c
            
            let c be the largest number, for loop this c
            if there exists left and right, which left + right > c,
            then every number on the right side of left, will be a valid pair too.
            So we can just add them and go to the next round (which is right--)
        */
        
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int length = nums.length;
        Arrays.sort(nums);
        for (int i = length - 1; i >= 0; --i) {
            int c = nums[i];
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > c) {
                    count += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }
        
        return count;
    }
}