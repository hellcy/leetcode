class Solution {
    public int balancedStringSplit(String s) {
        /*
            String
        */
        int count = 0;
        int balance = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'R') {
                balance++;
            } else if (s.charAt(i) == 'L') {
                balance--;
            }
            
            if (balance == 0) {
                count++;
            }
        }
        
        return count;
    }
}