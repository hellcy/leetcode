class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        /*
            array
            brute force
        */
        // int max = Integer.MIN_VALUE;
        // for (int i = 0; i < A.length; ++i) {
        //     for (int j = i + 1; j < A.length; ++j) {
        //         if (A[i] + A[j] < K) {
        //             if (max < (A[i] + A[j])) {
        //                 max = A[i] + A[j];
        //             }
        //         }
        //     }
        // }
        
        // if (max == Integer.MIN_VALUE) return -1;
        // else return max;

        /*
            Two pointers
            Array needs to be sorted to use two pointers
        */
        
        if (A == null || A.length == 0) return -1;
        int length = A.length;
        int left = 0, right = length - 1;
        Arrays.sort(A);
        
        int max = Integer.MIN_VALUE;
        while (left < right) {
            if (A[left] + A[right] >= K) {
                right--;
            } else {
                max = Math.max(max, A[left] + A[right]);
                left++;
            }
        }
        
        if (max == Integer.MIN_VALUE) return -1;
        return max;
    }
}