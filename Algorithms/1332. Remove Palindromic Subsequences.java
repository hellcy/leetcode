class Solution {
    public int removePalindromeSub(String s) {
        /*
            Answer can only be 0, 1 or 2
            the String s only consist of 'a' and 'b'
        */
        if (s.length() == 0) return 0;
        
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return 2;
            left++;
            right--;
        }
        
        return 1;
    }
}