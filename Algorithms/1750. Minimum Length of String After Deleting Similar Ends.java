class Solution {
    public int minimumLength(String s) {
        /*
            two pointers
        */
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                char c = s.charAt(left);
                while (left < right && s.charAt(left) == c) {
                    left++;
                }
                while (left < right && s.charAt(right) == c) {
                    right--;
                }
                if (s.charAt(left) == c) return 0;
                else if (left == right) return 1;
            } else {
                return right - left + 1;
            }
        }
        
        return 1;
    }
}