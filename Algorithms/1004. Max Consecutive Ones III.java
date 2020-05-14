class Solution {
    public int longestOnes(int[] A, int K) {
        /*
            sliding window
        */
        int length = A.length;
        if (A.length <= 0) return 0;
        
        int index = 0;
        int zero = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; ++i) {
            while (index < length && zero <= K) {
                if (A[index] == 0) zero++;
                if (zero <= K) max = Math.max(max, index - i + 1);
                index++;
            }
            
            if (zero > K) {
                if (A[i] == 0) zero--;
            }
        }
        
        if (max == Integer.MIN_VALUE) return 0;
        return max;
    }
}