class Solution {
    public String makeGood(String s) {
        System.out.println(s);
        int length = s.length();
        for (int i = 0; i < length - 1; ++i) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            if (check(a, b)) {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        
        return s;
    }
    
    private boolean check(char a, char b) {
        if (a < 97 && b >= 97 && a + 32 == b) return true;
        else if (a >= 97 && b < 97 && (b + 32 == a)) return true;
        else return false;
    }
}