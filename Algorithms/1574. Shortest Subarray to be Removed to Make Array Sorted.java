class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        /*
            1. the starting and ending part of the answer will be an increasing array
            2. we find the end position of the increasing array from the start
            3. we find the end position of the increasing array from the end
            4. now the last element of the prefix array maybe greater than the first element of the suffix array
            5. keep expand the middle part until we get the answer
        */
        
        int left = -1, right = -1;
        int n = arr.length;
        
        if (n < 2) return 0;
        for (int i = 1; i < n; ++i) {
            if (arr[i] < arr[i - 1]) {
                left = i - 1;
                break;
            }
        }
        if (left == -1) return 0;
        for (int i = n - 1; i >= 0; --i) {
            if (i - 1 >= 0 && arr[i] < arr[i - 1]) {
                right = i;
                break;
            }
        }
        //System.out.println(left + " " + right);
        int ans = Math.min(n - 1 - left, right);
        
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}