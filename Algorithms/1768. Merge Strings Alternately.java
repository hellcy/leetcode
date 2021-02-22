class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder ans = new StringBuilder();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        int index1 = 0, index2 = 0;
        while (index1 < cs1.length && index2 < cs2.length) {
            ans.append(cs1[index1]);
            ans.append(cs2[index2]);
            index1++;
            index2++;
        }

        if (index1 < cs1.length) {
            ans.append(word1.substring(index1));
        }

        
        if (index2 < cs2.length) {
            ans.append(word2.substring(index2));
        }

        return ans.toString();
    }
}