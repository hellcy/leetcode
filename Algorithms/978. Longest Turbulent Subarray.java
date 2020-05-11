class Solution {
    public int maxTurbulenceSize(int[] A) {
        /*
            sliding window
        */
        if (A.length <= 1) return A.length;
        int index = 0;
        int max = 1;
        for (int i = 0; i < A.length; ++i) {
            if (index < i) index = i;
            else i = index;
            while (index < A.length - 1 && check(A, index)) {
                max = Math.max(max, index - i + 2);
                index++;
            }
        }
        
        index = 0;
        for (int i = 0; i < A.length; ++i) {
            if (index < i) index = i;
            else i = index;
            while (index < A.length - 1 && check2(A, index)) {
                max = Math.max(max, index - i + 2);
                index++;
            }
        }
        
        return max;
    }
    
    private boolean check(int[] A, int index) {
        if (index % 2 == 0) return A[index] < A[index + 1];
        else return A[index] > A[index + 1];
    }
    
    private boolean check2(int[] A, int index) {
        if (index % 2 == 0) return A[index] > A[index + 1];
        else return A[index] < A[index + 1];
    }
}