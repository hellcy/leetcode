class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        /*
            HashMap
                store values in a map
                add keys that values are greater than 1 to the list
        */
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        int length = 10;
        
        for (int i = 0; i + 10 <= s.length(); ++i) {
            map.put(s.substring(i, i + 10), map.getOrDefault(s.substring(i, i + 10), 0) + 1);
        }
        
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                list.add(e.getKey());
            }
        }
        return list;
    }
}