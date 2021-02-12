class Solution {
    /*
        Union Find + DFS
    */
    class UnionFind {
        Map<String, String> map;
        public UnionFind() {
            map = new HashMap<>();
        }
        public String find(String str) {
            if (!map.containsKey(str)) {
                map.put(str, str);
                return str;
            }
            if (map.get(str).equals(str)) {
                return str;
            }
            map.put(str, find(map.get(str)));
            return map.get(str);
        }
        public void union(String x, String y) {
            String x_root = find(x);
            String y_root = find(y);
            map.put(x_root, y_root);
        }
    }
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> ans = new ArrayList<>();
        UnionFind uf = new UnionFind();
        for (List<String> list : synonyms) {
            uf.union(list.get(0), list.get(1));
        }
        
        Map<String, Set<String>> mapping = new HashMap<>();
        String[] strs = text.split(" ");
        for (String key : uf.map.keySet()) {
            String root = uf.find(key);
            if (!mapping.containsKey(root)) {
                mapping.put(root, new TreeSet<>());
            }
            mapping.get(root).add(key);
        }
        
        dfs(mapping, uf.map, "", 0, strs, ans);
        
        return ans;
    }
    private void dfs(Map<String, Set<String>> mapping, Map<String, String> parent, String value, int index, String[] strs, List<String> ans) {
        if (index == strs.length) {
            ans.add(value);
        } else {
            String space = index == strs.length - 1 ? "" : " ";
            if (!mapping.containsKey(parent.get(strs[index]))) {
                dfs(mapping, parent, value + strs[index] + space, index + 1, strs, ans);
            } else {
                for (String cur : mapping.get(parent.get(strs[index]))) {
                    dfs(mapping, parent, value + cur + space, index + 1, strs, ans);
                }
            }
        }
    }
}