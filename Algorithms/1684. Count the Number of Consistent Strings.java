class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        for (String str : words) {
            char[] cs = str.toCharArray();
            boolean flag = true;
            for (char c : cs) {
                if (!set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans++;
        }

        return ans;
    }
}