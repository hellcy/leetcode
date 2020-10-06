class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
            find max number of non overlapping intervals
            1. sort array by end points
            2. iterate intervals and keep updating endpoint
        */
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        
        int count = 1;
        int n = intervals.length;
        
        if (n == 0) return 0;
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        
        return n - count;
    }
}