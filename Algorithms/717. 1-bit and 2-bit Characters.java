class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        /*
            Algorithm explained:
                decode array from start
                    if we see a 0, index + 1;
                    if we see a 1, index + 2;
                keep decoing unitl the last bit, don't decode it
                    check index, if index stop at second last, we know the last one has to be decoded by oneBitChar
        */
        
        int index = 0;
        while (index < bits.length - 1) {
            if (bits[index] == 0) index++;
            else if (bits[index] == 1) index = index + 2;
        }
        
        if (index == bits.length - 1) return true;
        else return false;
    }
}