class Solution {
    public String longestNiceSubstring(String s) {
        /*
            Brute force
        */
        char[] cs = s.toCharArray();
        int n = cs.length;

        String ans = "";
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (helper(cs, i, j)) {
                    //System.out.println(ans + " " + i + " " + j);
                    if (j - i + 1 > ans.length()) {
                        ans = s.substring(i, j + 1);
                    }
                }
            }
        }
        return ans;
    }

    private boolean helper(char[] cs, int start, int end) {
        Map<Character, Set<Character>> map = new HashMap<>();

        for (int i = start; i <= end; ++i) {
            char c = cs[i];
            if (map.containsKey(c)) continue;
            if (c > 'Z') {
                if (!map.containsKey((char)(c - 'a' + 'A'))) {
                    Set<Character> set = new HashSet<>();
                    map.put(c, set);
                } else {
                    map.get((char)(c - 'a' + 'A')).add(c);
                }
            } else {
                if (!map.containsKey((char)(c - 'A' + 'a'))) {
                    Set<Character> set = new HashSet<>();
                    map.put(c, set);
                } else {
                    map.get((char)(c - 'A' + 'a')).add(c);
                }
            }
        }
        //System.out.println(map);

        for (char key : map.keySet()) {
            if (map.get(key).size() == 0) return false;
        }
        return true;
    }
}