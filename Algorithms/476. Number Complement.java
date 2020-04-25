class Solution {
    public int findComplement(int num) {
        /*
            Bit Manipulation
                find num's bit length
                toggle all bits by XOR another int with all bits are one
        */
        int mask = (1 << Integer.toBinaryString(num).length()) - 1;
        return num ^= mask;
    }
}