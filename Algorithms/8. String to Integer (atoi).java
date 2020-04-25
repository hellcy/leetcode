class Solution {
    public int myAtoi(String str) {
        /*
            Math
            Integer.MAX_VALUE
            int to double
            char to int
            too many corner cases
        */
        if (str.length() == 0) return 0;
        
        boolean first = true;
        int start = 0, end = str.length(), count = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (first && (str.charAt(i) == '+' || str.charAt(i) == '-' || (str.charAt(i) >= '0' && str.charAt(i) <= '9'))) {
                first = false;
                start = i;
                continue;
            }
            
            if (!first && (str.charAt(i) > '9' || str.charAt(i) < '0')) {
                end = i;
                break;
            }
            
            if (first && str.charAt(i) == ' ') count++;
        }
        
        if (first) return 0; // we never find a numeric value or '+' or '-'
        if (start - count != 0) return 0; // not all characters before 'start' are white spaces
        str = str.substring(start, end);
        //System.out.println(start + " " + end + " " + str);
        
        int index = 0;
        int number = 0;
        char temp = '+';
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            temp = str.charAt(index);
            index++;
        }
        
        for (; index < str.length(); ++index) {
            number = number * 10;
            number += str.charAt(index) - '0';
            //System.out.println(temp + " " + number);
            if (index + 1 < str.length() && Integer.MAX_VALUE / 10.0 < number + (str.charAt(index + 1) - '0') / 10.0) {
                if (temp == '+') number = Integer.MAX_VALUE;
                else if (temp == '-') number = Integer.MAX_VALUE + 1;
                break;
            }
        }
        
        if (temp == '+') return number;
        else return number * (-1);
    }
}