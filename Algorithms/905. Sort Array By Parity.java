class Solution {
    public int[] sortArrayByParity(int[] A) {
        /*
            Algorithm explained:
                two pointers: fast and slow
                fast is looking for even numbers, when found, exchange A[slow] and A[fast], increment both fast and slow
                if not found, go to next number
        */
        int slow = 0;
        int fast = 0;
        int temp;
        while (fast < A.length) {
            if (A[fast] % 2 != 0) {
                fast++;
            } else {
                temp = A[fast];
                A[fast] = A[slow];
                A[slow] = temp;
                fast++;
                slow++;
            }
        }
        return A;
    }
}