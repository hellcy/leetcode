class Solution {
    public int countSegments(String s) {
        /*
            String
            ASCII table
        */
        int count = 0;
        boolean flag = true;
        if (s.length() == 0) return 0;
        
        for (char c :  s.toCharArray()) {
            if (c == 32) {
                flag = true;
            } else if (c != 32 && flag) {
                flag = false;
                count++;
            }
        }
        
        return count;
    }
}