class Solution {
    public String destCity(List<List<String>> paths) {
        /*
            store cities in a hashmap
            if there is a city in the value but not in the key, return that city
        */
        Map<String, String> map = new HashMap<>();
        
        for (List<String> list : paths) {
            map.put(list.get(0), list.get(1));
        }
        
        for (String str : map.keySet()) {
            if (!map.containsKey(map.get(str))) {
                return map.get(str);
            }
        }
        
        throw null;
    }
}