/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 */

// @lc code=start
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /*
            there can only be at most 2 elements in the list
        */
        int first = 0, second = 0;
        int firstmax = 0, secondmax = 0;
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            if (firstmax == 0) {
                first = i;
                firstmax = 1;
            } else if (secondmax == 0) {
                second = i;
                secondmax = 1;
            } else {
                
            }
        }
    }
}
// @lc code=end

