class Solution {
    public boolean isArmstrong(int N) {
        /*
            Math
            int to String
        */
        int length = Integer.toString(N).length();
        int number = 0;
        int n = N;
        while (n >= 1) {
            number += Math.pow((n % 10), length);
            n = n / 10;
        }
        
        if (number == N) return true;
        else return false;
    }
}