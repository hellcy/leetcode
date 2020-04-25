class Solution {
    public boolean judgeSquareSum(int c) { 
        /*
            Math
            Sqrt
        */
        if (c == 0) return true;
        for (int i = 1; i <= c / i; ++i) {
            double b = Math.sqrt(c - i * i);
            if (b == (int)b) return true;
        }
        return false;
    }
}