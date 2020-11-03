/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        int index = 0;
        for (int i : nums) {
            array[index] = String.valueOf(i);
            index++;
        }

        Arrays.sort(array, new Comparator<String>() {
            public int compare(String a, String b) {
                String A = a + b;
                String B = b + a;
                int index = 0;
                while (index < A.length() && index < B.length() && A.charAt(index) == B.charAt(index)) {
                    index++;
                }
                if (index == A.length()) {
                    return -1;
                }
                
                return B.charAt(index) - A.charAt(index);
            }
        });

        String ans = "";
        for (String str : array) {
            ans += str;
        }

        if (ans.charAt(0) == '0') return "0";

        return ans;
    }
}
// @lc code=end

