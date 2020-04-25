class Solution {
    public boolean isMonotonic(int[] A) {
        /*
            Algorithm explained:
                if either monoIncrease or monoDecrease returns true
                we return true
        */
        return monoIncrease(A) || monoDecrease(A);
    }
    
    private boolean monoIncrease(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            if (A[i] < A[i - 1]) return false;
        }
        
        return true;
    }
    
    private boolean monoDecrease(int[] A) {
        for (int i = 1; i < A.length; ++i) {
            if (A[i] > A[i - 1]) return false;
        }

        return true;
    }
}