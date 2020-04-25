class Solution {
    public String addStrings(String num1, String num2) {
        /*
            StringBuilder
            Character
            String
        */
        int length1 = num1.length(), length2 = num2.length();
        
        int large = Math.max(length1, length2);
        
        StringBuilder str = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < large; ++i) {
            int number;
            if (length1 - 1 - i < 0) {
                number = (num2.charAt(length2 - 1- i) - '0') + carry;
            } else if (length2 - 1 - i < 0) {
                number = (num1.charAt(length1 - 1 - i) - '0') + carry;
            } else {
                number = (num1.charAt(length1 - 1 - i) - '0') + (num2.charAt(length2 - 1- i) - '0') + carry;
            }
            
            if (number >= 10) {
                carry = 1;
                number -= 10;
            } else {
                carry = 0;
            }
            
            str.append((char)(number + '0'));
        }
        
        if (carry == 1) {
            str.append((char)(carry + '0'));
        }
        
        str = str.reverse();
        return str.toString();
    }
}