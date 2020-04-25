class Solution {
    public boolean canPermutePalindrome(String s) {
        /*
            Stack
        */
        Stack<Character> stack = new Stack<>();
                
        for (char c : s.toCharArray()) {
            if (stack.contains(c)) stack.pop();
            else stack.add(c);
        }
        
        if (stack.size() <= 1) return true;
        else return false;
    }
}