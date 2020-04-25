class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        /*
            Algorithm explained:
                if the total sum of the array is not divisible by 3, return false;
                calculate the target number
                every time the sum of subarray hits target, count++
                if count == 3, return true
        */
        int n = A.length;
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += A[i];
        }
        
        if (sum % 3 != 0) return false;
        int target = sum / 3;
        sum = 0;
        int count = 0;
        for (int i = 0; i < n; ++i) {
            if (sum == target) {
                count++;
                sum = A[i];
            }
            else {
                sum += A[i];
            }
        }
        if (sum == target) count++;
        
        if (count == 3) return true;
        else return false;
    }
}