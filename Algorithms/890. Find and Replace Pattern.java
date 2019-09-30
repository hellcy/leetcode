class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        /*
            HashMap
        */
        Map<Character, Character> map = new HashMap<>();
        
        List<String> list = new ArrayList<>();
        for (String s : words) {
            boolean flag = true;
            for (int i = 0; i < pattern.length(); ++i) {
                char c = s.charAt(i);
                char p = pattern.charAt(i);
                if (!map.containsKey(p)) {
                    if (map.containsValue(c)) {
                        flag = false; 
                        break;
                    }
                    map.put(p, c);
                } else {
                    //System.out.println(map.get(p) + " " + c);
                    if (map.get(p) != c) {
                        flag = false;
                        break;
                    }
                }
            }
            map.clear();
            if (flag) list.add(s);
        }
        
        return list;
    }
}