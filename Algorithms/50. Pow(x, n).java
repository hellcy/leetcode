class Solution {
    public double myPow(double x, int n) {
        /*
            when we make -n from n, its outside the range of int, so we need to declare a long variable to store it
        */
        // long N = n;
        // if (N < 0) {
        //     N = -N;
        //     x = 1 / x;
        // } else if (N == 0) return 1;
        
        // return helper(x, N);

        /*
			iterative method
        */
        long N = n;
        if (N == 0) return 1.0;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        
        double product = 1.0;
        while (N > 1) {
            if (N % 2 == 0) {
                x = x * x;
            } else {
                product *= x;
                x = x * x;
            }
             N /= 2;
        }
        
        x *= product;
        
        return x;
	}
            
    private double helper(double x, long n) {
        if (n == 1) return x;
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        } else {
            return x * helper(x * x, n / 2);
        }
    }
}