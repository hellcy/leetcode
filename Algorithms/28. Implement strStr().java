class Solution {
    public int strStr(String haystack, String needle) {
        /*
            String
            Two pointers
        */
        int pointerA = 0, pointerB = 0;
        while (pointerA < haystack.length() && pointerB < needle.length()) {
            if (haystack.charAt(pointerA) == needle.charAt(pointerB)) {
                pointerA++;
                pointerB++;
            } else {
                pointerA = pointerA - pointerB + 1;
                pointerB = 0;
            }
        }
        
        if (pointerB == needle.length()) {
            return pointerA - needle.length();
        } else {
            return -1;
        }
    }
}