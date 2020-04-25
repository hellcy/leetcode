class Solution {
    public boolean canWinNim(int n) {
        /*
            first 15 results are:
                4 lose
                5,6,7 win
                8 lose
                9,10,11 win
                12 lose
                13,14,15 win
            
            we lose on the multiple of 4
            the reason is we know 4 will lose, so 5,6,7 can give 4 to our opponent
            but 8 will give 5,6,7 to opponent
        */
        if (n % 4 == 0) return false;
        else return true;
    }
}