class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;
        while (n >= 1) {
            if (n % 2 == 0) {
                if (prev == 0) return false;
                prev = 0;
            } else {
                if (prev == 1) return false;
                prev = 1;
            }
            n /= 2;
        }
        
        return true;
    }
}