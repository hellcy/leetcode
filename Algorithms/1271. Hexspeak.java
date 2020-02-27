class Solution {
    /*
        StringBuilder
        String to int
    */
    String[] array = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    public String toHexspeak(String num) {
        StringBuilder str = new StringBuilder(toHex(num));
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if (c == 48) str.replace(i, i + 1, "O");
            else if (c == 49) str.replace(i, i + 1, "I");
            else if (c < 65) return "ERROR";
        }
        
        return str.reverse().toString();
    }
    
    private String toHex(String num) {
        long x = Long.valueOf(num);
        String ans = "";
        while (x >= 1) {
            ans += array[(int)(x % 16)];
            x /= 16;
        }
        System.out.println(ans);
        return ans;
    }
}