class Solution {
    public int minFlips(String target) {
        int count = 1;
        int index = target.length();
        if (index == 0) return 0;
        for (int i = index - 2; i >= 0; --i) {
            char c = target.charAt(i);
            char prev = target.charAt(i + 1);
            if (c != prev) count++;
        }
        
        if (target.charAt(0) == '0') count--;
        
        return count;
    }
}