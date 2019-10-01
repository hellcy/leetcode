class Solution {
    public String customSortString(String S, String T) {
        /*
            StringBuilder
            Brute force
        */
        StringBuilder ans = new StringBuilder();
        StringBuilder t = new StringBuilder(T);
        for (int i = 0; i < S.length(); ++i) {
            for (int j = 0; j < T.length(); ++j) {
                if (T.charAt(j) == S.charAt(i)) {
                    ans.append(T.charAt(j));
                    t.setCharAt(j, '.');
                }
            }
        }
        for (int i = 0; i < t.length(); ++i) {
            if (t.charAt(i) != '.') {
             ans.append(t.charAt(i));   
            }
        }
        
        return ans.toString();
    }
}