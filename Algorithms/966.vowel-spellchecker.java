/*
 * @lc app=leetcode id=966 lang=java
 *
 * [966] Vowel Spellchecker
 */

// @lc code=start
class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] ans = new String[queries.length];
        int index = 0;
        for (String str : queries) {
            boolean found = false;
            for (String cur : wordlist) {
                if (str.equals(cur) || rule(cur, str)) {
                    ans[index] = cur;
                    found = true;
                    break;
                }
            }
            if (!found) ans[index] = "";
            index++;
        }

        return ans;
    }

    private boolean rule(String word, String query) {
        char[] cs1 = word.toCharArray();
        char[] cs2 = query.toCharArray();

        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        if (cs1.length != cs2.length) return false;
        for (int i = 0; i < cs1.length; ++i) {
            char c1 = cs1[i];
            char c2 = cs2[i];
            if (set.contains(c2) && set.contains(c1)) continue;
            if (c2 == c1 || (c2 - 32 == c1) || (c1 - 32 == c2)) continue;
            
            return false;
        }
        return true;
    }
}
// @lc code=end

