class Solution {
    public int[] prevPermOpt1(int[] A) {
        /*
            Array
        */
        if (A.length <= 1) return A;
        int pointA = 10001, pointB = 10001;
        int index = 0;
        
        // start from the end of the array, we can't swap when it is an increasing array
        // so find the first element where make it not incresing, save its value and index to pointA
        for (int i = A.length - 2; i >= 0; --i) {
            if (A[i] > A[i + 1]) {
                pointA = A[i];
                index = i;
                break;
            }
        }
        
        // it the whole array is an incresing array, return itself
        if (pointA == 10001) return A;
        
        // find the largest value smaller than pointA, now we know which two values we want to swap, but we don't know the first time pointB appear
        for (int i = A.length - 1; i >= 0; --i) {
            if (A[i] < pointA) {
                pointB = A[i];
                A[index] = A[i];
                break;
            }
        }
        
        // find the index where pointB appear for the first time, make the swap
        for (int i = index + 1; i < A.length; ++i) {
            if (A[i] == pointB) {
                A[i] = pointA;
                break;
            }
        }
        return A;
    }
}