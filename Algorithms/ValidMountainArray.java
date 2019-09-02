class Solution {
    public boolean validMountainArray(int[] A) {
        /*
            Algorithm explained:
                find the max number in the array
                check if all values from max's left are increasing
                check if all values from max's right are decresing
                return true if all satisfied
        */
        if (A.length < 3) return false;
        int max = 0;
        int index = -1;
        for (int i = 0; i < A.length; ++i) {
            if (max < A[i]) {
                max = A[i];
                index = i;
            }
        }
        for (int i = 1; i < index; ++i) {
            if (A[i] <= A[i - 1]) return false;
        }
        
        for (int i = index + 1; i < A.length; ++i) {
            if (A[i] >= A[i - 1]) return false;
        }
        
        if (index == 0 || index == A.length - 1) return false;
        return true;
    }
}