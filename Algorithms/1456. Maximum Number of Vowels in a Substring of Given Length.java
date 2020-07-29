class Solution {
    public int maxVowels(String s, int k) {
        /*
            Two pointers
        */
        int max = 0;
        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            while (index < s.length() && index - i < k) {
                char c = s.charAt(index);
                if (check(c)) {
                    count++;
                    max = Math.max(max, count);
                }
                index++;
            }
            
            if (index - i == k) {
                char c = s.charAt(i);
                if (check(c)) {
                    count--;
                }
            }
        }
        
        return max;
    }
    
    private boolean check(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}