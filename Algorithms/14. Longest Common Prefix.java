class Solution {
    public String longestCommonPrefix(String[] strs) {
        /*
            Brute force
            String
        */
        if (strs.length == 0) return "";
        String common = strs[0];
        
        for (int i = 1; i < strs.length; ++i) {
            String temp = "";
            for (int j = 0; j < Math.min(common.length(), strs[i].length()); ++j) {
                char c = common.charAt(j);
                if (c == strs[i].charAt(j)) {
                    temp += String.valueOf(c);
                } else {
                    break;
                }
            }
            common = temp;
            if (common.length() == 0) return "";
        }
        
        return common;
    }
}