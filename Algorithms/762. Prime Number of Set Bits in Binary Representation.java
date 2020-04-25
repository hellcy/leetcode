class Solution {
    public int countPrimeSetBits(int L, int R) {
        /*
            Bit Manipulation
                count the number of set bits by check the last bit and shift to right by one
                then check if number is prime
        */
        int count = 0;
        for (int i = L; i <= R; ++i) {
            if (isPrime(check(i))) count++;
        }
        return count;
    }
    
    private int check(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        //System.out.println("count: " + count);
        return count;
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) return false;
        }
        //System.out.println(n);
        return true;
    }
}