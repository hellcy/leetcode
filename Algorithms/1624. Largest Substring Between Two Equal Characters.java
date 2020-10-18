class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        int ans = -1;
        
        char[] array = s.toCharArray();
        
        for (int i = 0; i < array.length; ++i) {
            char c = array[i];
            if (pos[c - 'a'] == -1) pos[c - 'a'] = i;
            else {
                ans = Math.max(ans, i - pos[c - 'a'] - 1);
            }
        }
        
        return ans;
    }
}