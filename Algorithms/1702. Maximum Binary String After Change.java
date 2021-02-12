class Solution {
    public String maximumBinaryString(String binary) {
        /*
            count how many ones are in the string (after the first zero)
            move all of them to the end of string
            now all zeros are at front of string
            change as many of them to 1 as possible
        */
        char[] cs = binary.toCharArray();
        int ones = 0;
        boolean found = false;
        for (char c : cs) {
            if (c == '0') found = true;
            if (found && c == '1') ones++;
        }
        
        if (!found) return binary;
        
        int n = cs.length;
        char[] ans = new char[n];
        Arrays.fill(ans, '0');
        for (int i = 0; i < n - ones - 1; ++i) {
            ans[i] = '1';
        }
        
        for (int i = n - ones; i < n; ++i) {
            ans[i] = '1';
        }
        
        return String.valueOf(ans);
    }
}