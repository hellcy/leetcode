class Solution {
    public int numSpecialEquivGroups(String[] A) {
        int count = 0;
        Set<String> set = new HashSet<>();
        
        for (String str : A) {
            boolean found = false;
            for (String target : set) {
                if (helper(str, target)) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
                set.add(str);  
            } 
        }
        
        return set.size();
    }
    
    private boolean helper(String a, String b) {
        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < ca.length; ++i) {
            char c = ca[i];
            if (i % 2 == 0) {
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            } else map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        //System.out.println(map1);
        //System.out.println(map2);
        
        for (int i = 0; i < cb.length; ++i) {
            char c = cb[i];
            if (i % 2 == 0) {
                if (!map1.containsKey(c)) return false;
                else {
                    map1.put(c, map1.get(c) - 1);
                    if (map1.get(c) == 0) map1.remove(c);
                }
            } else {
                if (!map2.containsKey(c)) return false;
                else {
                    map2.put(c, map2.get(c) - 1);
                    if (map2.get(c) == 0) map2.remove(c);
                }
            }
        }
        
        return map1.size() == 0 && map2.size() == 0;
    }
}