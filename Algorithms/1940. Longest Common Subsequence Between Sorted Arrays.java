class Solution {
    public List<Integer> longestCommomSubsequence(int[][] arrays) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arrays[0].length; ++i) {
            set.add(arrays[0][i]);
        }
        
        for (int i = 1; i < arrays.length; ++i) {
            Set<Integer> current = new HashSet<>();
            for (int j = 0; j < arrays[i].length; ++j) {
                if (set.contains(arrays[i][j])) {
                    current.add(arrays[i][j]);
                }
            }
            set = current;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i : set) {
            list.add(i);
        }
        
        Collections.sort(list);
        
        return list;
    }
}