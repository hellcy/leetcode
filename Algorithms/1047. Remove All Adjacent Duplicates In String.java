class Solution {
    public String removeDuplicates(String S) {
        /*
            Recursion
        */
        char[] cs = S.toCharArray();
        
        for (int i = 1; i < S.length(); ++i) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                return removeDuplicates(S.substring(0, i - 1) + S.substring(i + 1, S.length()));
            }
        }
        return S;
    }
}