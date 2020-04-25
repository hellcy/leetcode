class Solution {
    public int rotatedDigits(int N) {
        /*
            String
            Brute force
        */
        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (check(String.valueOf(i))) count++;
        }
        
        return count;
    }
    
    private boolean check(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); ++i) {
            int digit = Integer.parseInt(String.valueOf(s.charAt(i)));
            if (digit == 0 || digit == 1 || digit == 8) {
                temp += String.valueOf(digit);
            } else if (digit == 2) {
                temp += "5";
            } else if (digit == 5) {
                temp += "2";
            } else if (digit == 6) {
                temp += "9";
            } else if (digit == 9) {
                temp += "6";
            } else {
                return false;
            }
        }
        if (!temp.equals(s)) return true;
        else return false;
    }
}