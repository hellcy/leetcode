class Solution {
    public String freqAlphabets(String s) {
        /*
            String
        */
        char[] array1 = {'a','b','c','d','e','f','g','h','i'};
        char[] array2 = {'j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        
        String str = "";
        int index = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                index = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
                str += Character.toString(array2[index - 10]);
                i += 2;
            } else {
                index = s.charAt(i) - '0';
                str += Character.toString(array1[index - 1]);
            }
        }
        
        return str;
    }
}