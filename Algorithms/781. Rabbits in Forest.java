/*
 * @lc app=leetcode id=781 lang=java
 *
 * [781] Rabbits in Forest
 */

// @lc code=start
class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : answers) {
            if (i == 0) {
                ans += 1;
                continue;
            }
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int num = map.get(i);
                if (num == i) {
                    ans += num + 1;
                    map.remove(i);
                } else {
                    map.put(i, num + 1);
                }
            }
        }
        //System.out.println(map);
        for (int key : map.keySet()) {
            ans += key + 1;
        }

        return ans;
    }
}
// @lc code=end

