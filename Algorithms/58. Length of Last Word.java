class Solution {
    public int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        
        if (arr.length == 0) return 0;
        
        int ans = 0;
        for (String str : arr) {
            if (str.length() == 0) continue;
            ans = str.length();
        }
        
        return ans;
    }
}