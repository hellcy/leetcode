class Solution {
    public int maxDiff(int num) {
        /*
            1. find the first integer that is not 9, change all that integer to 9
            2. if the first integer is 1, start from the second integer, find the first integer that is not 0, change all that integer to 0
            3. if the first integer is not 1, change all that integer to 1.
        */
        String str = String.valueOf(num);
        
        String a = "";
        String b = "";
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c != '9') {
                for (char c2 : str.toCharArray()) {
                    if (c2 == c) {
                        c2 = '9';
                    }
                    a += Character.toString(c2);
                }
                break;
            }
        }
        
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (i == 0 && c == '1') {
                i++;
                while (i < str.length()) {
                    char c2 = str.charAt(i);
                    if (c2 != '0' && c2 != '1') {
                       for (char c3 : str.toCharArray()) {
                            if (c3 == c2) {
                                c3 = '0';
                            }
                            b += Character.toString(c3);
                        }
                        break;
                    }
                    i++;
                }
                break;
            }
            else {
                for (char c2 : str.toCharArray()) {
                    if (c2 == c) {
                        c2 = '1';
                    }
                    b += Character.toString(c2);
                }
                break;
            }
        }
        //System.out.println(a + " " + b);
        if (a.equals("")) a = str;
        if (b.equals("")) b = str;
        int inta = Integer.valueOf(a);
        int intb = Integer.valueOf(b);
        
        return Math.abs(inta - intb);
    }
}