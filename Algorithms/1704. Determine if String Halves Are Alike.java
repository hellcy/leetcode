class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        return countVowel(s.substring(0, n / 2)) == countVowel(s.substring(n / 2));
    }
    
    private int countVowel(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                count++;
            }
        }
        
        return count;
    }
}