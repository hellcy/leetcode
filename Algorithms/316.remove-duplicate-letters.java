import java.util.Iterator;

/*
 * @lc app=leetcode id=316 lang=java
 *
 * [316] Remove Duplicate Letters
 */

// @lc code=start
class Solution {
    public String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Set<Integer>> map = new HashMap<>();

        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];
            if (!map.containsKey(c)) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(c, set);
            } else {
                map.get(c).add(i);
            }
        }

        List<String> list = new ArrayList<>();
        char[] arr = new char[cs.length];
        Arrays.fill(arr, 'A');
        char[] keys = new char[map.size()];
        int index = 0;
        for (char key : map.keySet()) {
            keys[index] = key;
            index++;
        }

        dfs(arr, list, map, keys, 0);

        Collections.sort(list);
        return list.get(0);
    }

    private void dfs(char[] arr, List<String> list, Map<Character, Set<Integer>> map, char[] keys, int index) {
        if (index == keys.length) {
            String str = "";
            for (char c : arr) {
                if (c != 'A') {
                    str += Character.toString(c);
                }
            }
            list.add(str);
        } else {
            Set<Integer> set = map.get(keys[index]);
            for (int i : set) {
                arr[i] = keys[index];
                dfs(arr, list, map, keys, index + 1);
                arr[i] = 'A';
            }
        }
    }
}
// @lc code=end

