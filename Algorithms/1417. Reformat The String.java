class Solution {
    public String reformat(String s) {
        /*
            brute force
        */
        StringBuilder ans = new StringBuilder(s);
        int slow = 0, fast = 0;
        int digits = 0, chars = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c >= 97) chars++;
            else digits++;
        }
        
        if (Math.abs(chars - digits) >= 2) return "";
        if (chars > digits) {
                for (int i = 0; i < s.length(); ++i) {
                char c = ans.charAt(i);
                if (i % 2 == 0) {
                    if (c >= 97) {
                        slow++;
                        fast++;
                    } else {
                        while (fast < ans.length() && ans.charAt(fast) < 97) fast++;
                        if (fast >= ans.length()) return "";
                        char temp = ans.charAt(fast);
                        ans.replace(fast, fast + 1, String.valueOf(c));
                        ans.replace(i, i + 1, String.valueOf(temp));
                        slow++;
                        fast = slow;
                    }
                } else {
                    if (c < 97) {
                        slow++;
                        fast++;
                    } else {
                        while (fast < ans.length() && ans.charAt(fast) >= 97) fast++;
                        if (fast >= ans.length()) return "";
                        char temp = ans.charAt(fast);
                        ans.replace(fast, fast + 1, String.valueOf(c));
                        ans.replace(i, i + 1, String.valueOf(temp));
                        slow++;
                        fast = slow;
                    }
                }
            }
        } else {
                for (int i = 0; i < s.length(); ++i) {
                char c = ans.charAt(i);
                if (i % 2 == 0) {
                    if (c < 97) {
                        slow++;
                        fast++;
                    } else {
                        while (fast < ans.length() && ans.charAt(fast) >= 97) fast++;
                        if (fast >= ans.length()) return "";
                        char temp = ans.charAt(fast);
                        ans.replace(fast, fast + 1, String.valueOf(c));
                        ans.replace(i, i + 1, String.valueOf(temp));
                        slow++;
                        fast = slow;
                    }
                } else {
                    if (c >= 97) {
                        slow++;
                        fast++;
                    } else {
                        while (fast < ans.length() && ans.charAt(fast) < 97) fast++;
                        if (fast >= ans.length()) return "";
                        char temp = ans.charAt(fast);
                        ans.replace(fast, fast + 1, String.valueOf(c));
                        ans.replace(i, i + 1, String.valueOf(temp));
                        slow++;
                        fast = slow;
                    }
                }
            }
        }
        
        
        //System.out.println(ans.toString());
        return ans.toString();
    }
}