class Solution {
    public boolean checkRecord(String s) {
        /*
            String
            ACSII table
        */
        int countA = 0, countL = 0;
        for (char c : s.toCharArray()) {
            if (c == 65) {
                countA++;
                if (countA >= 2) return false;
                countL = 0;
            }
            else if (c == 76) {
                countL++;
                if (countL >= 3) return false;
            } else {
                countL = 0;
            }
        }
        
        return true;
    }
}