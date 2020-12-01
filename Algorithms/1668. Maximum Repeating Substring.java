class Solution {
    public int maxRepeating(String sequence, String word) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        char[] cs = sequence.toCharArray();
        int n = cs.length;
        for (int i = 0; i < n; ++i) {
            char c = cs[i];
            if (!map.containsKey(c)) {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(c, set);
            } else {
                map.get(c).add(i);
            }
        }
        
        char first = word.charAt(0);
        if (!map.containsKey(first)) return 0;
        int max = 0;
        int length = word.length();
        for (int i : map.get(first)) {
            int cur = 0;
            int index = i;
            while (index + length <= n) {
                 if (sequence.substring(index, index + length).equals(word)) {
                    cur++;
                    max = Math.max(max, cur);
                     index += length;
                } else {
                     break;
                 }
            }
        }
        
        return max;
    }
}