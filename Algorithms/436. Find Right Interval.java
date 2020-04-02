class Solution {
    public int[] findRightInterval(int[][] intervals) {
        /*
            Bianry search
                store original indexes in a hashmap
                for each interval, find its first right interval, assign this first right interval's original index into the array
        */
        if (intervals == null || intervals.length <= 1) return new int[] {-1};
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; ++i) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                
        int[] ans = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; ++i) {
            //System.out.println(intervals[i][0] + " " + intervals[i][1]);
            int point = intervals[i][1];
            int start = i, end = intervals.length - 1;
            while (start + 1 < end) {
                int mid = (end - start) / 2 + start;
                
                if (intervals[mid][0] == point) end = mid;
                if (intervals[mid][0] > point) end = mid;
                else start = mid;
            }
            
            if (intervals[start][0] == point) {
                int index = map.get(intervals[start]);
                ans[map.get(intervals[i])] = index;
            }
            else if (intervals[end][0] == point) {
                int index = map.get(intervals[end]);
                ans[map.get(intervals[i])] = index;
            } else {
                //System.out.println(start + " " + end);
                if (intervals[start][0] > point) ans[map.get(intervals[i])] = map.get(intervals[start]);
                else if (intervals[end][0] > point) ans[map.get(intervals[i])] = map.get(intervals[end]);
                else ans[map.get(intervals[i])] = -1;
            }
        }
        
        return ans;
    }
}