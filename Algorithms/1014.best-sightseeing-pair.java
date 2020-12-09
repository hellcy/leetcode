/*
 * @lc app=leetcode id=1014 lang=java
 *
 * [1014] Best Sightseeing Pair
 */

// @lc code=start
class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        /*
            PriorityQueue
        */

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] + b[0] + a[1] - b[1];
            }
        });
        for (int i = 0; i < A.length; ++i) {

        }
    }
}
// @lc code=end

