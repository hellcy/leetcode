class Solution {
    public int[] sortArrayByParityII(int[] A) {
        /*
            Algorithm explained:
                two pointers: fast and slow
                fast is looking for next even or odd number. 
                If fast is looking for even this round, then will looking for odd next round
        */
        int slow = 0;
        int fast = 0;
        int temp;
        while (fast < A.length) {
            if ((A[fast] + slow) % 2 != 0) {
                fast++;
            } else {
                temp = A[fast];
                A[fast] = A[slow];
                A[slow] = temp;
                slow++;
            }
        }
        return A;
    }
}