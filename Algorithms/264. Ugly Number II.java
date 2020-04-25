class Solution {
    public int nthUglyNumber(int n) {
        /*
            Dynamic programming
                the next ugly number can only be 2, 3 or 5 multiple by a previous ugly number.
        */
        int two = 0, three = 0, five = 0;
        
        if (n == 0) return 0;
        int[] array = new int[n];
        array[0] = 1;
        
        for (int i = 1; i < array.length; ++i) {
            int number = Math.min(array[two] * 2, Math.min(array[three] * 3, array[five] * 5));
            
            array[i] = number;
            
            if (number == array[two] * 2) two++;
            if (number == array[three] * 3) three++;
            if (number == array[five] * 5) five++;
        }
        
        return array[n - 1];
    }
}