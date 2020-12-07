import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=1054 lang=java
 *
 * [1054] Distant Barcodes
 */

// @lc code=start
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        /*
            Similar to question 767. Reorganize string
            1. find the Integer with max time of occurance
            2. rearrange the other nums in order: 
                e.g. 1,1,1,1,1,2,2,3,3,4
                take out '1' ('1' occurs the most time), 2,2,3,3,4 is left
                rearrage to: 2,3,4,2,3
                put '1' back from right to left (insert from right to left because it is easier to calculate the insert position): 2,1,3,1,4,1,2,1,3,1
        */
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, maxnum = 0;
        for (int i :  barcodes) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            if (map.get(i) > maxnum) {
                maxnum = map.get(i);
                max = i;
            } 
        }

        map.remove(max);
        List<Integer> list = new ArrayList<>();
        while (map.size() > 0) {
            Set<Integer> set = new HashSet<>();
            for (int key : map.keySet()) {
                list.add(key);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) set.add(key);
            }

            for (int key : set) {
                map.remove(key);
            }
        }

        int index = list.size();
        while (maxnum > 0) {
            list.add(index, max);
            maxnum--;
            index--;
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
// @lc code=end

