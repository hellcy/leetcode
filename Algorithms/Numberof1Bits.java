public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        /*
            Bit Manipulation
                loop and shift
                for each bit over the 32 bits, we check if last bit
                if it is one, we add one to the count
                then shift the n to the right by one, until finish 32 bits
        */  
        // int count = 0;
        // for (int i = 0; i < 32; ++i) {
        //     //System.out.println(Integer.toBinaryString(n));
        //     if ((n & 1) == 1) count++;
        //     n = n >> 1;
        // }
        // return count;
        /*
            Bit manipulation
                flip the last significant one by using AND
                n & (n - 1) will flip the least significant one to zero
                by using this fact we can check if the n is zero, if not, flip the least significant one to zero
                until n is zero
        */
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}