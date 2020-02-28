class Solution {
    public int largestPerimeter(int[] A) {
        /*
            Sort
            Math
        */
        Arrays.sort(A);
        
        for (int i = A.length - 1; i >= 2; --i) {
            if (A[i - 1] + A[i - 2] > A[i]) {
                return A[i - 1] + A[i - 2] + A[i];
            }
        }
        
        return 0;
    }
}