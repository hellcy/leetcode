class Solution {
    public String longestPalindrome(String s) {
        /*
            String
                for each character, do two things
                    1. check if equals to the previous character, then expend to both sides
                    2. expend to both sides
                    3. find the max length of these two methods
                return max length of all max lengths of each character
        */
        if (s.length() <= 1) return s;
        int count = 1, max = 1;
        String ans = "";
        for (int i = 1; i < s.length() - 1; ++i) {
            int j = 1;
            count = 1;
            boolean flag = true;
            
            
            if (s.charAt(i - 1) == s.charAt(i + 1)) {
                while (i - j >= 0 && i + j < s.length()) {
                    if (s.charAt(i - j) == s.charAt(i + j)) {
                        count += 2;
                        j++;
                    } else {
                        break;
                    }
                    //System.out.println(count + " " + j);
                }
            } 
            
            int tempmax = count;
            int tempj = j;
            j = 1;
            count = 1;
            
            if (s.charAt(i - 1) == s.charAt(i)) {
                count++;
                flag = false;
                while (i - j - 1>= 0 && i + j < s.length()) {
                    if (s.charAt(i - j - 1) == s.charAt(i + j)) {
                        count += 2;
                        j++;
                    } else {
                        break;
                    }
                }
            }
            if (tempmax > count) {
                j = tempj;
                count = tempmax;
                flag = true;
            }
            if (max < count) {
                j--;
                //System.out.println(count + " " + max + " " + i + " " + j);
                max = count;
                if (flag) ans = s.substring(i - j, i + j + 1);
                else ans = s.substring(i - j - 1, i + j + 1);
            }
        }
        
        if (max == 1 && s.charAt(s.length() - 2) == s.charAt(s.length() - 1)) {
            return s.substring(s.length() - 2);
        }
        
        if (max == 1) return s.substring(0, 1);
        
        return ans;
    }
}