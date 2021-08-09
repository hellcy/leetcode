class Solution {
    public int minSwaps(String s) {
        int level = 0;
        int maxLevel = 0;
        for (char c : s.toCharArray()) {
            if (c == ']') {
                level++;
            } else {
                level--;
            }
            
            if (level > maxLevel) {
                maxLevel = level;
            }
        }
        
        return maxLevel % 2 == 0 ? maxLevel / 2 : maxLevel / 2 + 1;
    }
}