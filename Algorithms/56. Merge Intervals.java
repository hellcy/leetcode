class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
           } 
        });
        
        List<int[]> list = new ArrayList<>();
        
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; ++i) {
            if (current[1] < intervals[i][0]) {
                list.add(current);
                current = intervals[i];
            } else {
                current[0] = Math.min(current[0], intervals[i][0]);
                current[1] = Math.max(current[1], intervals[i][1]);
            }
        }
        
        list.add(current);
        
        int[][] ans = new int[list.size()][2];
        
        int index = 0;
        for (int[] array : list) {
            ans[index] = array;
            index++;
        }
        
        return ans;
    }
}