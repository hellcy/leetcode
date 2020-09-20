class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        int length = 1;
        int n = arr.length;
        while (length <= n) {
            int start = 0;
            while (start + length <= n) {
                sum += helper(arr, start, length);
                start++;
            }
            length += 2;
        }
        
        return sum;
    }
    
    private int helper(int[] arr, int start, int length) {
        int sum = 0;
        while (length > 0) {
            length--;
            sum += arr[start];
            start++;
        }
        
        return sum;
    }
}