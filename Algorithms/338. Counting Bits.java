class Solution {
    public int[] countBits(int num) {
        /*
            Bit manipulation brute force
                for each number in the range
                count the number of set bits and assign to the array
        */
        // int[] array = new int[num + 1];
        // for (int i = 0; i <= num; ++i) {
        //     array[i] = counting(i);
        // }
        // return array;
        
        /*
            Bit manipulation Dynamic Programming
                for each number
                if it is even, then number of one bits should equal to (number / 2)
                if it is odd, then number of one bits should equal to (number / 2) + 1
        */
        int[] array = new int[num + 1];
        array[0] = 0;
        if (num == 0) return array;
        array[1] = 1;
        for (int i = 2; i <= num; ++i) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + 1;
            }
        }
        return array;
        
    }
    
    private int counting(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }
}