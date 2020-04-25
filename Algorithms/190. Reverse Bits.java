public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        /*
            Bit Manipulation
                for each bit, get the last bit of n and assign it to the mask by shifting it to the most right
                then get the next bit of n until n is zero, then fill out mask with zeros
        */
        int mask = 0;
        for (int i = 0; i < 32; ++i) {
            if (n != 0) {
                mask |= (n & 1) << (31 - i);
                n = n >> 1;
            } else {
                mask |= 0 << (31 - i); 
            }
        }
        return mask;
    }
}