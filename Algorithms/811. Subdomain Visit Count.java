class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        /*
            Hash map
                for each string in cpdomains
                split it into string array
                add each subdomain and its value to the map, also in the inner loop connect substring one by one
                write the values from map to list
        */
        Map<String, Integer> map = new HashMap<>();
        
        for (String s : cpdomains) {
            String[] array = s.split("[ .]+");
            String key = array[array.length - 1];
            for (int i = array.length - 2; i >= 0 ; --i) {
                map.put(key, map.getOrDefault(key, 0) + Integer.valueOf(array[0]));
                key = array[i] + "." + key;
            }
            
            //System.out.println(map);
        }
        
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            list.add(e.getValue() + " " + e.getKey());
        }
        return list;
    }
}