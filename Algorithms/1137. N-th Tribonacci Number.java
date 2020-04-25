class Solution {
    public int tribonacci(int n) {
        /*
            Dynamic programming
        */
        int[] array = new int[n+1];
        if (n == 0) {
            return 0;
        }
        if (n < 3) {
            return 1;
        }
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        
        for (int i = 3; i <= n; ++i) {
            array[i] = array[i - 1] + array[i - 2] + array[i - 3];
        }
        
        return array[n];
        
        /*
            Recursion
                time limit exceeded
        */
        // if (n == 0) {
        //     return 0;
        // } else if (n == 1 || n == 2) return 1;
        // else {
        //     return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        // }
    }
}