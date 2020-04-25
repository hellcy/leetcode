class Solution {
    public int minDeletionSize(String[] A) {
        /*
            Greedy
                if a column isn't sorted, then we have to delete it, add 1 to count
                until all remaining columns are sorted
        */
        int count = 0;
        for (int i = 0; i < A[0].length(); ++i) {
            for (int j = 1; j < A.length; ++j) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
    
}