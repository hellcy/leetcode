class Solution {
    public int numberOfDays(int Y, int M) {
        /*
            Math
                check leap year
        */
        int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        if (M == 2 && checkLeap(Y)) {
            return 29;
        } else return months[M];
        
    }
    
    private boolean checkLeap(int y) {
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return true;
        else return false;
    }
}