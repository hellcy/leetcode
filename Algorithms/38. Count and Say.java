class Solution {
    public String countAndSay(int n) {
        /*
            String
            Dynamic Programming
        */
        String[] array = new String[n];
        array[0] = String.valueOf(1);
        for (int i = 1; i < array.length; ++i) {
            array[i] = helper(array[i - 1]);
        }
        return array[n - 1];
    }
    
    private String helper(String s) {
        int count = 1;
        String str = "";
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
            } else {
                str += String.valueOf(count) + String.valueOf(s.charAt(i - 1));
                count = 1;
            }
        }
        
        str += String.valueOf(count) + String.valueOf(s.charAt(s.length() - 1));
        return str;
    }
}