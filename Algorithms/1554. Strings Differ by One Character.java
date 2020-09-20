class Solution {
    public boolean differByOne(String[] dict) {
        int length = dict.length;
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                if (check(dict[i], dict[j])) return true;
            }
        }
        
        return false;
    }
    
    private boolean check(String A, String B) {
        int length = A.length();
        boolean flag = false;
        for (int i = 0; i < length; ++i) {
            if (A.charAt(i) != B.charAt(i)) {
                if (flag) {
                    return false;
                }
                flag = true;
            }
        }
        
        return true;
    }
}