class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        /*
            Set
        */
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < intervals.length; ++i) {
            for (int j = intervals[i][0]; j < intervals[i][1]; ++j) {
                if (set.contains(j)) {
                    return false;
                } else {
                    set.add(j);
                }
            }
        }
        
        return true;
    }
}