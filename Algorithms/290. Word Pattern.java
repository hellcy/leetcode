class Solution {
    public boolean wordPattern(String pattern, String str) {
        /*
            HashMap
        */
        Map<Character, String> map = new HashMap<>();
        
        char[] cs = pattern.toCharArray();
        
        String[] array = str.split(" ");
        if (cs.length != array.length) return false;
        for (int i = 0; i < array.length; ++i) {
            if (!map.containsKey(cs[i])) {
                if (map.containsValue(array[i])) return false;
                map.put(cs[i], array[i]);
            } else {
                if (!map.get(cs[i]).equals(array[i])) return false;
            }
        }
        
        return true;
    }
}