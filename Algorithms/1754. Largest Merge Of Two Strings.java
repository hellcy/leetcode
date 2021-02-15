class Solution {
    public String largestMerge(String word1, String word2) {
        /*
            Simulation
            append the larger char to ans
            if current chars are the same, keep comparing the next char until we found a larger char
        */
        StringBuilder ans = new StringBuilder();
        int start1 = 0, end1 = 0, start2 = 0, end2 = 0;
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        while (end1 < cs1.length && end2 < cs2.length) {
            if (cs1[end1] > cs2[end2]) {
                ans.append(cs1[end1]);
                end1++;
            } else if (cs1[end1] < cs2[end2]) {
                ans.append(cs2[end2]);
                end2++;
            } else {
                start1 = end1;
                start2 = end2;
                while (end1 < cs1.length && end2 < cs2.length && cs1[end1] == cs2[end2]) {
                    end1++;
                    end2++;
                }
                if (end1 == cs1.length) {
                    ans.append(cs2[start2]);
                    end2 = start2 + 1;
                    end1 = start1;
                } else if (end2 == cs2.length) {
                    ans.append(cs1[start1]);
                    end1 = start1 + 1;
                    end2 = start2;
                } else if (cs1[end1] > cs2[end2]) {
                    ans.append(cs1[start1]);
                    end1 = start1 + 1;
                    end2 = start2;
                } else {
                    ans.append(cs2[start2]);
                    end2 = start2 + 1;
                    end1 = start1;
                }
            }
        }

        if (end1 < cs1.length) {
            ans.append(word1.substring(end1));
        }
        if (end2 < cs2.length) {
            ans.append(word2.substring(end2));
        }

        return ans.toString();
    }
}