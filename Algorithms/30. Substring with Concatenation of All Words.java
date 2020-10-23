/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        int n = words[0].length();

        int index = 0;
        while (index + n <= s.length()) {
            Map<String, Integer> map = helper(words);
            int cur = index;
            String target = s.substring(cur, cur + n);
            boolean ok = false;
            while (map.containsKey(target) && cur + n <= s.length()) {
                int num = map.get(target);
                if (num == 1) map.remove(target);
                else map.put(target, num - 1);
                cur += n;
                if (cur + n <= s.length()) target = s.substring(cur, cur + n);
                if (map.size() == 0) {
                    ans.add(index);
                    //map.put(s.substring(index, index + n), 1);
                    //index += n;
                    //ok = true;
                }
            }
            //System.out.println(map);
            //System.out.println(cur);
            index = index + 1;
        }

        return ans;
    }

    private Map<String, Integer> helper(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        return map;
    }
}
// @lc code=end

