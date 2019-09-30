class Solution {
    public int smallestRangeI(int[] A, int k) {
        /*
            Math
            find largest difference in A, compare that value with 2K
        */
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i : A) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }
        
        int difference = (max - min) - 2 * k;
        
        if (difference < 0) return 0;
        else return difference;
    }
}