class Solution {
    int max = 0;
    public int maxUniqueSplit(String s) {
        /*
            backtracking
        */
        
        dfs(s, 0, new ArrayList<>());
        
        return max;
    }
    
    private void dfs(String s, int index, List<String> set) {
        if (index == s.length()) {
            //Set<String> set2 = new HashSet<>(set);
            max = Math.max(max, set.size());
        } else if (index < s.length()) {
            for (int i = index; i < s.length(); ++i) {
                String sub = s.substring(index, i + 1);
                if (set.contains(sub)) continue;
                set.add(sub);
                //System.out.println(set);
                dfs(s, i + 1, set);
                set.remove(sub);
            }
        }
    }
}