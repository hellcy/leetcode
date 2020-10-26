class Solution {
    public int longestMountain(int[] A) {
        int ans = 0, cur = 1;
        int left = 0, right = 1;
        boolean start = false, pass = false;
        while (right < A.length) {
            if (A[right - 1] == A[right]) {
                start = false;
                right++;
            }
            else if (A[right - 1] > A[right]) {
                if (start) {
                    pass = true;
                    ans = Math.max(ans, right - left + 1);
                    right++;
                }
                else {
                    right++;
                }
            } else {
                if (pass || !start) {
                    pass = false;
                    left = right - 1;
                }
                start = true;
                right++;
            }
        }
        
        return ans;
    }
}