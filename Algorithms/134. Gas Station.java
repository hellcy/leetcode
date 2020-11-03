/*
 * @lc app=leetcode id=134 lang=java
 *
 * [134] Gas Station
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
            try all statioins
            Time O(N^2)
        */
        // for (int i = 0; i < gas.length; ++i) {
        //     boolean found = false;
        //     int j = i;
        //     int start = j;
        //     int cur = 0;
        //     while (!found) {
        //         cur += gas[j];
        //         cur -= cost[j];
        //         //System.out.println(j + " " + cur);
        //         if (cur < 0) {
        //             break;
        //         }
        //         j++;
        //         j = j % gas.length;
        //         if (j == start) return start;
        //     }
        // }

        // return -1;

        /*
            Greedy
            At any point if the gas is negative, start at next station
            If the total number of gas is bigger than the total number of cost. There must be a solution.
        */

        int extra = 0, total = 0;
        int n = gas.length;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            extra += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if (extra < 0) {
                extra = 0;
                start = i + 1;
            }
        }

        return total >= 0 ? start : -1;
    }
}
// @lc code=end

