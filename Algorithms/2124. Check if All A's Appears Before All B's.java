class Solution {
    public boolean checkString(String s) {
        // two pointers
        int length = s.length();
        int left = 0, right = length - 1;
        
        while (left < length - 1) {
            if (s.charAt(left) == 'a') {
                left++;
            } else break;
        }
        
        while (right >= 0) {
            if (s.charAt(right) == 'b') {
                right--;
            } else break;
        }
        
        return left >= right;
        
    }
}