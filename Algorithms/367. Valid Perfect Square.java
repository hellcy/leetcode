class Solution {
    public boolean isPerfectSquare(int num) {
        /*
            Binary Search
                every time compare mid number's square and num
                because (mid * mid) could exceed int max value, we use (num / mid) compare with (mid) instead
                remember to cast (num / mid) to double or it will omit decimal part
        */
        if (num == 1) return true;
        int low = 0;
        int high = num;
        while (low <= high) {
            int mid = (low + high) / 2;
            //System.out.println(mid + " " + num / mid);
            if ((double)num / mid < mid) {
                high = mid - 1;
            } else if ((double)num / mid > mid) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}