class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < intervals.length; ++i) {
            //System.out.println(intervals[i][0]);
            if (!flag && intervals[i][0] > newInterval[1]) {
                flag = true;
                list.add(newInterval);
            }
            if (intervals[i][1] < newInterval[0] || intervals[i][0] > newInterval[1]) {
                list.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                while (i < intervals.length && intervals[i][1] <= newInterval[1]) i++;
                if (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                    newInterval[1] = intervals[i][1];
                } else i--;
                
                list.add(newInterval);
                flag = true;
            }
        }
        
        if (intervals.length == 0 || !flag) list.add(newInterval);
        
        int[][] ans = new int[list.size()][2];
        
        int index = 0;
        for (int[] interval : list) {
            ans[index] = interval;
            index++;
        }
        
        return ans;
    }
}