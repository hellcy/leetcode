class Solution {
    public boolean closeStrings(String word1, String word2) {
        /*
            HashMap, check number of occurance of each char
        */
        
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        for (char c: cs1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        for (char c : cs2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        //System.out.println(map1);
        //System.out.println(map2);
        if (map1.size() != map2.size()) return false;
        for (char key : map1.keySet()) {
            if (!map2.containsKey(key)) return false;
        }
        
        for (char key : map1.keySet()) {
            //System.out.println(key);
            int num = map1.get(key);
            boolean flag = false;
            for (char key2 : map2.keySet()) {
                int num2 = map2.get(key2);
                if (num2 == num) {
                    map2.remove(key2);
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        
        if (map2.size() == 0) return true;
        return false;
    }
}