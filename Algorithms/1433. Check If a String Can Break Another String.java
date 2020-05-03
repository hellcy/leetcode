class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        /*
            for each character in s1, find a smallest possible character in s2 that is equal to or greater than the character in s1
            if we can't find such character in s2, s2 can't break s1, check the reverse and return the answer
        */
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for (char c : s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        
        for (char c : s2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        
        return checkbreak(s1, s2, map1, map2) || checkbreak(s2, s1, map2, map1);
    }
    
    private boolean checkbreak(String s1, String s2, Map<Character, Integer> map1, Map<Character, Integer> map2) {
        //System.out.println(map2);
        for (char c : s1.toCharArray()) {
            boolean flag = false;
            for (char c2 = c; c2 <= 'z'; ++c2) {
                if (map2.containsKey(c2) && map2.get(c2) > 0) {
                    map2.put(c2, map2.get(c2) - 1);
                    flag = true;
                    break;
                }
            }
            //System.out.println(map2);
            if (!flag) {
                return false;
            }
        }
        
        return true;
    }
}