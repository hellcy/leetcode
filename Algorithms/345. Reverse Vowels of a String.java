class Solution {
    public String reverseVowels(String s) {
        /*
            Stack?
                keep track of all vowels than pop back to a Stringbuilder whenever there is a vowel
        */
        StringBuilder str = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (vowels(c)) {
                stack.add(c);
            }
        }
        
        for (int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            
            if (vowels(c)) {
                str.replace(i, i + 1, stack.pop().toString());
            }
        }
        
        return str.toString();
    }
    
    private boolean vowels(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;    
        } else return false;
    }
}