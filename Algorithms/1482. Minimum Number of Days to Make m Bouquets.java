class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        /*
            binary search  
        */
        
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i : bloomDay) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }
        
        if (!check(bloomDay, max, m, k)) return -1;
        while (min + 1 < max) {
            int mid = (max - min) / 2 + min;
            if (check(bloomDay, mid, m, k)) {
                max = mid;
            } else {
                min = mid;
            }
        }
        if (check(bloomDay, min, m, k)) return min;
        return max;
    }
    
    private boolean check(int[] bloomDay, int mid, int m, int k) {
        int count = 0;
        int slow = 0, fast = 0;
        while (slow < bloomDay.length && fast < bloomDay.length) {
            if (count == m) return true;
            if (fast - slow == k) {
                count++;
                slow = fast;
            }
            else if (bloomDay[fast] <= mid) {
                fast++;
            } else {
                fast++;
                slow = fast;
            }
        }
        
        if (fast - slow == k) {
            count++;
            if (count == m) return true;
        }
        return false;
    }
}