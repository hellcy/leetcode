class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        /*
            Binary Search
                Similar to question 1011. Capacity To Ship Packages Within D Days
                find the range of value k, given mid number as k, calculate how many hours it would take to finish piles
                the compare hours with H, and determine the next candidate k until we found the answer
        */
        int max = Integer.MIN_VALUE;
        for (int i : piles) {
            max = Math.max(max, i);
        }
        int low = 1;
        int high = max;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            //System.out.println(mid + " " + check(piles, mid));
            if (check(piles, mid) > H) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
        
    }
    
    private int check(int[] piles, int k) {
        int count = 0;
        for (int i : piles) {
            count += (int)Math.ceil((double)i / k);
        }
        return count;
    }
}