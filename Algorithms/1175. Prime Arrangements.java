class Solution {
    public int numPrimeArrangements(int n) {
        /*
            Algorithm explained:
                calculate the number of prime numbers up to n
                calculate the permutations
                    by multiply from 1 to prime number
                    and multiply from 1 to (n - prime number)
                decrement the ans by modulo to prevent overflow
        */
        int primeCount = 0;
        for (int i = 2; i <= n; ++i) {
            if (isPrime(i)) primeCount++;
        }
        
        long ans = 1;
        for (int i = 1; i <= primeCount; ++i) {
            ans *= i;
            ans = ans % (int)(Math.pow(10, 9) + 7);
        }
        
        for (int i = 1; i + primeCount <= n; ++i) {
            ans *= i;
            ans = ans % (int)(Math.pow(10, 9) + 7);
        }
        
        return (int)ans;
    }
    
    private boolean isPrime(int n) {
        for (int i = 2; i < n; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
}