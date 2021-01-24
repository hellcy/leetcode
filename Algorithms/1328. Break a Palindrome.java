class Solution {
    public String breakPalindrome(String palindrome) {
        String ans = "";

        int n = palindrome.length();
        if (n == 1) return ans;
        boolean found = false;
        for (int i = 0; i < n; ++i) {
            if ((n % 2 == 0 || i != n / 2) && palindrome.charAt(i) != 'a') {
                found = true;
                ans = palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
                return ans;
            }
        }

        return palindrome.substring(0, n - 1) + "b";
    }
}