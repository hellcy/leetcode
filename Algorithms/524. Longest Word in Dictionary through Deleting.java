class Solution {
    public String findLongestWord(String s, List<String> d) {
        /*
            two pointers
        */
        int max = 0;
        String maxword = "";
        for (String str : d) {
            if (check(s, str)) {
                if (max < str.length()) {
                    max = str.length();
                    maxword = str;
                } else if (max == str.length()) {
                    if (maxword.compareTo(str) > 0) {
                        maxword = str;
                    }
                }
            }
        }
        return maxword;
    }
    
    private boolean check(String a, String b) {
        int index1 = 0, index2 = 0;
        while (index1 < a.length() && index2 < b.length()) 
        {
            char c1 = a.charAt(index1);
            char c2 = b.charAt(index2);
            if (c1 == c2) {
                index1++;
                index2++;
            } else 
            {
                index1++;
            }
        }
        if (index2 < b.length()) {
            return false;
        }
        
        return true;
    }
}