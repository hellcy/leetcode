/*
 * @lc app=leetcode id=820 lang=java
 *
 * [820] Short Encoding of Words
 */

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        /*
            reverse the strings and compare prefix of strings
        */
        String[] arr = new String[words.length];
        for (int i = 0; i < words.length; ++i) {
            arr[i] = reverse(words[i]);
        }

        Arrays.sort(arr);
        // for (String str : arr) 
        // {
        //     System.out.print(str + " ");
        // }
        int ans = arr[0].length();
        int n = arr.length;
        int num = 1;
        String prev = arr[0];
        for (int i = 1; i < n; ++i) {
            boolean flag = true;
            String cur = arr[i];
            int prevlength = prev.length();
            int curlength = cur.length();
            int length = Math.min(prevlength, curlength);
            int index = 0;
            //System.out.println(prev + " " + cur);
            while (length > 0) {
                if (prev.charAt(index) != cur.charAt(index)) {
                    flag = false;
                    break;
                }
                index++;
                length--;
                //System.out.println(index + " " + length);
            }

            if (flag) {
                if (prevlength < curlength) {
                    ans -= prevlength;
                    ans += curlength;
                    prev = cur;
                }
            } else {
                ans += curlength;
                prev = cur;
                num++;
            }
        }
        return ans + num;
    }

    private String reverse(String str) {
        char[] cs = new char[str.length()];
        int index = 1;
        for (char c : str.toCharArray()) {
            cs[cs.length - index] = c;
            index++;
        }
        return String.copyValueOf(cs);
    }
}
// @lc code=end

