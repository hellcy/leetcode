class Solution {
    public String reorderSpaces(String text) {
        char[] cs = text.toCharArray();
        
        int spaces = 0;
        String[] arr = text.split(" ");
        int words = 0;
        
        for (String str : arr) {
            if (str.length() == 0) continue;
            words++;
        }
        
        for (char c : cs) {
            if (c == ' ') spaces++;
        }
                
        String ans = "";
        
        String s = "";
        
        if (words == 1) {
            for (String str : arr) {
                if (str.length() == 0) continue;
                ans += str;
            }
            
            for (int i = 0; i < spaces; ++i) {
                ans += " ";
            }
            return ans;
        }
        
        
        
        int length = spaces / (words - 1);
        int reminder = spaces % (words - 1);

        for (int i = 0; i < length; ++i) {
            s += " ";
        }
        
        String rs = "";
        for (int i = 0; i < reminder; ++i) {
            rs += " ";
        }
        
        for (String str : arr) {
            if (str.length() == 0) continue;
            ans += str;
            ans += s;
        }
        
        ans = ans.substring(0, ans.length() - length);
        ans += rs;
        return ans;
    }
}