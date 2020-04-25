class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        /*
            Bit Manipulatio brute force
                perform AND for each num in the range
                if we get zero in the process, we know the final answer will be zero, so return zero
        */
        // int ans = n;
        // for (int i = m; i < n; ++i) {
        //     ans &= i;
        //     if (ans == 0) return ans;
        // }
        // return ans;
        /*
            Bit Manipulation
                for a given range, if Two numbers are not Equal, 
                The consecutive number between them Will contain ZERO at each digit, 
                thus their bitwise AND will be ZERO.
                So we need to keep chopping the last significant bit until the numbers are equal
                return that number
                
                example: 
                    101
                    111
                    --- not equal
                     10
                     11
                     -- not equal
                      1
                      1
                      - equal
              but we need to return 100, since that is the original bits position
        */
        int count = 0;
        while (m != n) {
            count++;
            m = m >> 1;
            n = n >> 1;
        }
        m = m << count;
        return m;
    }
}