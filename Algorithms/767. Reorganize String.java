import java.util.Map;

/*
 * @lc app=leetcode id=767 lang=java
 *
 * [767] Reorganize String
 */

// @lc code=start
class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = S.toCharArray();

        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0, total = 0;
        char maxc = 'a';
        for (char key : map.keySet()) {
            int num = map.get(key);
            total += num;
            if (num > max) {
                max = num;
                maxc = key;
            }
        }

        if (max > total - max + 1) return "";
        map.remove(maxc);

        StringBuilder str = new StringBuilder();
        while (map.size() > 0) {
            Set<Character> set = new HashSet<>();
            for (char key : map.keySet()) {
                str.append(key);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) set.add(key);
            }

            for (char key : set) {
                map.remove(key);
            }
        }

        int index = str.length();
        while (max > 0) {
            str.insert(index, maxc);
            index--;
            max--;
        }
        return str.toString();
    }
}
// @lc code=end

