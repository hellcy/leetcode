class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        /*
            String
            Character
            Array
        */
        int position = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            String number = "";
            boolean flag = false;
            while (c - '0' >= 0 && c - '0' < 10 && i < abbr.length()) {
                if (!flag && c - '0' == 0) return false;
                flag = true;
                number += String.valueOf(c);
                i++;
                if (i < abbr.length()) c = abbr.charAt(i);
            }
            
            if (flag) {
                position += Integer.valueOf(number);
                i--;
                continue;
            }
            else if (position >= word.length() || word.charAt(position) != c) {
                //System.out.println(position + " " + i + " " + c);
                return false;
            }
            position++;
            //System.out.println(position + " " + i + " " + c);
        }
        
        //System.out.println(position);
        if (position != word.length()) return false;
        return true;
    }
}