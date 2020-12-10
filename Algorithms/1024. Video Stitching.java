/*
 * @lc app=leetcode id=1024 lang=java
 *
 * [1024] Video Stitching
 */

// @lc code=start
class Solution {
    public int videoStitching(int[][] clips, int T) {
        /*
            Sort intervals
            at each step, find the best next interval
            O(n^2) time, n is the length of clips
            O(1) space
        */
        Arrays.sort(clips, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        int start = 0;
        int ans = 0;
        for (int i = 0; i < clips.length; ++i) {
            if (clips[i][0] <= start && clips[i][1] > start) {
                ans++;
                //System.out.println(clips[i][0] + " " + clips[i][1]);
                start = clips[i][1];
                if (start >= T) return ans;

                int max = -1;
                int maxindex = -1;
                for (int j = i + 1; j < clips.length; ++j) {
                    if (clips[j][0] <= start) {
                        if (clips[j][1] > max) {
                            max = clips[j][1];
                            maxindex = j;
                        }
                    }
                }
                if (maxindex != -1) i = maxindex - 1;
            }
        }

        if (start < T) return -1;
        else return ans;
    }
}
// @lc code=end

