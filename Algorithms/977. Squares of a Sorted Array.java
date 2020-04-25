class Solution {
    public int[] sortedSquares(int[] A) {
        /*
            calculate the square
            then sort the array
        */

        for (int i = 0; i < A.length; ++i) {
            A[i] = A[i] * A[i];
        }
        
        //Arrays.sort(A);
        // insertion sort
        // int temp;
        // for (int i = 1; i < A.length; ++i) {
        //     for (int j = i; j > 0; --j) {
        //         if (A[j] < A[j - 1]) {
        //             temp = A[j];
        //             A[j] = A[j - 1];
        //             A[j - 1] = temp;
        //         }
        //     }
        // }
        
        // merge sort
        int start = 0;
        int end = A.length - 1;
        merge_sort(A, start, end);
        
        return A;
    }
    
    private void merge_sort(int[] A, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            
            merge_sort(A, start, mid);
            merge_sort(A, mid + 1, end);
            
            merge(A, start, mid, end);
        }
    }
    
    private void merge(int[] A, int start, int mid, int end) {
        int p = start, q = mid + 1, k = 0;
        int[] array = new int[end - start + 1];
        while (k < array.length) {
            if (p > mid) array[k++] = A[q++];
            else if (q > end) array[k++] = A[p++];
            else if (A[p] < A[q]) array[k++] = A[p++];
            else array[k++] = A[q++];
        }
        
        for (int i = 0; i < array.length; ++i) {
            A[start++] = array[i];
        }
    }
}