class Solution {
    public int minPartitions(String n) {
        int ans = 1;
        for (char c : n.toCharArray()) {
            ans = Math.max(ans, (int)(c - '0'));
        }

        return ans;
    }
}