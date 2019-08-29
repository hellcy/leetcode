class Solution {
    public int[] sortedSquares(int[] A) {
        /*
            get rid of the minus sign
            then sort and square
        */
        for (int i = 0; i < A.length; ++i) {
            A[i] = Math.abs(A[i]);
        }
        
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }
        return A;
    }    
}