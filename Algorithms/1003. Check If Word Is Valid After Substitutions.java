class Solution {
    String check = "abc";
    public boolean isValid(String S) {
        /*
            Recursion
        */
        //System.out.println(S);
        if (S.length() == 0) return true;
        
        for (int i = 0; i < S.length() - 2; ++i) {
            if (S.substring(i, i + 3).equals(check)) {
                return isValid(S.substring(0, i) + S.substring(i + 3));
            }
        }
        return false;
    }
}