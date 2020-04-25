class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            HashMap
                To put anagrams into the same group, we need to store them under the same map key
                we sort the string and use the sorted string as key
                use a array list as value
        */
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array =  s.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)) {
                List<String> newlist = new ArrayList<>();
                newlist.add(s);
                map.put(key, newlist);
            } else {
                map.get(key).add(s);
            }
        }
        
        //System.out.println(map);
        for (String s : map.keySet()) {
            list.add(map.get(s));
        }
        return list;
    }
}