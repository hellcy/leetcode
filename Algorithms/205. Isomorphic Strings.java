class Solution {
    public boolean isIsomorphic(String s, String t) {
        /*
            HashMap
                use first string as key and the other string as value
                also use second string as key and first string as value to make sure no exceptions
        */
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        
        for (int i = 0; i < cs.length; ++i) {
            if (!map1.containsKey(cs[i])) {
                map1.put(cs[i], ct[i]);
            } else {
                if (map1.get(cs[i]) != ct[i]) return false;
            }
            
            if (!map2.containsKey(ct[i])) {
                map2.put(ct[i], cs[i]);
            } else {
                if (map2.get(ct[i]) != cs[i]) return false;
            }
        }
        
        return true;
    }
}