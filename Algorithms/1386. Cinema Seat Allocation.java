/*
 * @lc app=leetcode id=1386 lang=java
 *
 * [1386] Cinema Seat Allocation
 */

// @lc code=start
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        int row = -1;
        int ans = 0;
        int reservedRow = 0;
        Set<Integer> set = new HashSet<>();
        for (int[] currow : reservedSeats) {
            if (currow[0] != row) {
                if (row != -1) {
                    int num = helper(set);
                    ans += num;
                    reservedRow++;
                }
                row = currow[0];
                set = new HashSet<>();
                set.add(currow[1]);
            } else {
                set.add(currow[1]);
            }
        }

        int num = helper(set);
        ans += num;
        reservedRow++;

        ans += (n - reservedRow) * 2;

        return ans;
    }

    private int helper(Set<Integer> set) {
        if ((!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) && (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9))) {
            return 2;
        } else if (!set.contains(2) && !set.contains(3) && !set.contains(4) && !set.contains(5)) {
            return 1;
        } else if (!set.contains(6) && !set.contains(7) && !set.contains(8) && !set.contains(9)) {
            return 1;
        } else if (!set.contains(4) && !set.contains(5) && !set.contains(6) && !set.contains(7)) {
            return 1;
        }

        return 0;
    }
}
// @lc code=end

