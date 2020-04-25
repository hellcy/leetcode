class Solution {
    public String convertToBase7(int num) {
        /*
            StringBuilder
        */
        StringBuilder str = new StringBuilder();
        boolean flag = false;
        if (num < 0) {
            flag = true;
            num = -num;
        }
        
        while (num >= 7) {
            str.append(num % 7);
            num /= 7;
        }
        
        str.append(num);
        if (flag)  {
            str.append('-');
        }
        
        str = str.reverse();
        
        return str.toString();
    }
}