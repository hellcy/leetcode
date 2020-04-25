class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        /*
            array
            brute force
        */
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                if (A[i] + A[j] < K) {
                    if (max < (A[i] + A[j])) {
                        max = A[i] + A[j];
                    }
                }
            }
        }
        
        if (max == Integer.MIN_VALUE) return -1;
        else return max;
    }
}