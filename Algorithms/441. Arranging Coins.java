class Solution {
    public int arrangeCoins(int n) {
        /*
            Math
            Binary Search
                formula for adding from 1 to mid is (1 + mid) * mid / 2
                But this will result in a number exceed max value of int
                So we compare it with n, if n < (1 + mid) * mid / 2, we can't make mid number of stairs
                change the formula to (n / (double)mid - (1 + (double)mid) / 2), and compare it with zero 
        */
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            double sum = n / (double)mid - (1 + (double)mid) / 2;
            //System.out.println(mid + " " + sum);
            if (sum < 0) {
                high = mid - 1;
            } else if (sum > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        
        return low - 1;
    }
}