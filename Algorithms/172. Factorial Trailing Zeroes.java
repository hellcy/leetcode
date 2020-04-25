class Solution {
    public int trailingZeroes(int n) {
        /*
            Math
            number of occurance of fives between 0 to n
        */
        int count = 0;
        int five = 1;
        while (n >= Math.pow(5, five)) {
            count += n / Math.pow(5, five);
            five++;
        }
        
        return count;
    }
}