class Solution {
    public int fixedPoint(int[] A) {
        /*
            loop
        */
        for (int i = 0; i < A.length; ++i) {
            if (i == A[i]) return i;
            if (A[i] > i) return -1;
        }
        
        return -1;
    }
}