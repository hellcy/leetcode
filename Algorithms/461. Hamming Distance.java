class Solution {
    public int hammingDistance(int x, int y) {
        /*
            Algorithm explained:
                for a int type, max length of its bit form is 32
                use & 1 to filter the rest bits except the last one
                if the last bits are different, count++
                shift both x and y to the right by 1 to get rid of the last bit
        */
        int count = 0;
        for(int i=0;i<32;i++) {
            if( ((x&1)!=(y&1)))
                count++;

            x= x>>1;
            y= y>>1;
        }
        return count;
    }
}