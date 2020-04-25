class Solution {
    public int maximum69Number (int num) {
        /*
            StringBuilder
            String to int
        */
        StringBuilder numstr = new StringBuilder(Integer.toString(num));
        for (int i = 0; i < numstr.length(); ++i) {
            if (numstr.charAt(i) == '6') {
                numstr.replace(i, i + 1, "9");
                break;
            }
        }
        
        return Integer.parseInt(numstr.toString());
    }
}