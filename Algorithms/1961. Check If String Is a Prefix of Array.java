class Solution {
    public boolean isPrefixString(String s, String[] words) {
        String current = "";
        for (String word : words) {
            current += word;
            if (current.equals(s)) return true;
        }
        
        return false;
    }
}