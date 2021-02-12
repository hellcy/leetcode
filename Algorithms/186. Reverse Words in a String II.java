class Solution {
    public void reverseWords(char[] s) {
        /*
            reverse the entire array first
            then for each word, reverse it again
        */

        int n = s.length;
        for (int i = 0; i < n / 2; ++i) {
            char temp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = temp;
        } 

        int start = 0;
        for (int i = 0; i < n; ++i) {
            if (s[i] == ' ') {
                helper(start, i - 1, s);
                start = i + 1;
            }
        }
        
        helper(start, n - 1, s);
    }

    private void helper(int start, int end, char[] arr) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}