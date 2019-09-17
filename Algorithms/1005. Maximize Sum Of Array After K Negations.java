class Solution {
    public int largestSumAfterKNegations(int[] A, int k) {
        /*
            Greedy
        */
        
        // first sort the array
        Arrays.sort(A);
        
        /*
            keep fliping the negative values in the array, until 
                there is no more negative values or
                k reaches zero or
                we are at the end of the array
        */
        int index = 0;
        for (; index < A.length; ++index) {
            if (k > 0 && A[index] < 0) {
                k--;
                A[index] = -A[index];
            } else {
                break;
            }
        }
        
        /*
            at this stage, if k is even, we just skip this step and calculate the sum
            if k is odd, 
                if index is zero, which means whole array are all positive numbers at the begining, we simply flip the first value
                if index >= A.length, we are at the end of the array, flip the last value in the array
                if A[index] >= A[index - 1], we are at middle of the array, and we want to flip the smallest value in the array
                which is either A[index], or A[index - 1], so we compare them and flip the smaller one
        */
        if (k % 2 != 0) {
            if (index == 0) A[index] = -A[index]; 
            else if (index >= A.length || A[index] >= A[index - 1]) A[index - 1] = -A[index - 1];
            else A[index] = -A[index];
        }
        
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        return sum;
    }
}