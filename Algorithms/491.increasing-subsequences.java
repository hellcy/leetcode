/*
 * @lc app=leetcode id=491 lang=java
 *
 * [491] Increasing Subsequences
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        /*
            DFS
        */ 
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> visited = new HashSet<>();
        dfs(lists, new ArrayList<>(), nums, 0);

        return lists;
    }

    private void dfs(List<List<Integer>> lists, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            if (list.size() >= 2) {
                List<Integer> temp = new ArrayList<>(list);
                Collections.sort(temp);
                if (!lists.contains(temp)) lists.add(temp);
            }
        } else {
            if (list.size() >= 2) {
                List<Integer> temp = new ArrayList<>(list);
                Collections.sort(temp);
                if (!lists.contains(temp)) lists.add(temp);
            }
            for (int i = index; i < nums.length; ++i) {
                if (index != i && nums[i] == nums[i - 1]) continue;
                if (list.size() > 0 && nums[i] < list.get(list.size() - 1)) continue;
                list.add(nums[i]);
                dfs(lists, list, nums, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
// @lc code=end

