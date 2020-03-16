class Solution {
//     int count = 0;
    
//     public int climbStairs(int n) {
//         helper(n);
//         return count;
//     }
    
//     // TLE
//     private void helper(int n) {
//         if (n < 0) {
//             return;
//         }
        
//         if (n == 0) {
//             count++;
//         }
        
//         helper(n - 1);
//         helper(n - 2);
//     }
    
    /*
        to reach ith step, we can
            take a single step from i - 1th step, or
            take a single step or a step of 2 from i - 2th step
        so f(n) = f(n - 1) + 2 * f(n - 2)
        but there are duplicates, take a single step from i - 2th step is already included in the i - 1th step
        so f(n) = f(n - 1) + f(n - 2)
    */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < array.length; ++i) {
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[n - 1];
    }
}