class Solution {
    public List<List<String>> partition(String s) {
        /*
            Backtracking
        */
        
        List<List<String>> lists = new ArrayList<>();
        char[] cs = s.toCharArray();
        
        dfs(s, lists, new ArrayList<>(), 0, 0);
        
        return lists;
    }
    
    private void dfs(String s, List<List<String>> lists, List<String> list, int length, int index) {        
        if (s.length() == length) {
            lists.add(new ArrayList<>(list));
        } else if (length < s.length()) {
            for (int i = index; i < s.length(); ++i) {
                String str = s.substring(index, i + 1);
                if (!isPalin(str)) continue;
                list.add(str);
                dfs(s, lists, list, length + str.length(), i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isPalin(String str) {
        char[] cs = str.toCharArray();
        for (int i = 0; i < cs.length / 2; ++i) {
            if (cs[i] != cs[cs.length - 1 - i]) return false;
        }
        
        return true;
    }
}