class Solution {
    public String reformatNumber(String number) {
        int count = 0;
        char[] cs = number.toCharArray();
        String ans = "";
        String temp = "";
        for (char c : cs) {
            if (c != '-' && c != ' ') {
                temp += Character.toString(c);
            }
        }
        
        int left = temp.length();
        
        int index = 0;
        while (left > 4) {
            ans += temp.substring(index, index + 3);
            ans += "-";
            left -= 3;
            index += 3;
        }
        
        if (left == 4) {
            ans += temp.substring(index, index + 2);
            ans += "-";
            index += 2;
            ans += temp.substring(index, index + 2);
        } else if (left == 3) {
            ans += temp.substring(index);
        } else if (left == 2) {
            ans += temp.substring(index);
        }
        
        return ans;
    }
}