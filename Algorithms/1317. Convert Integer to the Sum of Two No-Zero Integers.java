class Solution {
    /*
        Math
    */
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; ++i) {
            if (!hasZero(i) && !hasZero(n - i)) return new int[] {i, n - i};
        }
        throw null;
    }
    
    private boolean hasZero(int x) {
        while (x >= 10) {
            if (x % 10 == 0) return true;
            x /= 10;
        }
        return false;
    }
}