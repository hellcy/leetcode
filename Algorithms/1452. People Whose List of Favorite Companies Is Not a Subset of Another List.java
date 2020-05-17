class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        /*
            HashMap
            Set
        */
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<String>> map = new HashMap<>();
        int length = favoriteCompanies.size();
        
        for (int i = 0; i < length; ++i) {
            Set<String> set = new HashSet<>();
            set.addAll(favoriteCompanies.get(i));
            map.put(i, set);
        }
        
        for (int i = 0; i < length; ++i) {
            boolean flag = false;
            for (int j = 0; j < length; ++j) {
                if (i != j && check(map, i, j)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                list.add(i);
            }
        }
        
        Collections.sort(list);
        return list;
    }
    
    private boolean check(Map<Integer, Set<String>> companies, int i, int j) {
        Set<String> str1 = companies.get(i);
        Set<String> str2 = companies.get(j);
        for (String str : str1) {
            if (!str2.contains(str)) return false;
        }
        
        return true;
    }
}