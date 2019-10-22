class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        /*
            HashMap
                Store list1 and list2 into two maps
                find common key in two maps, add them with sum of index to another map
                get the keys with minimum values in the new map and add them to a list
        */
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        for (int i = 0; i < list1.length; ++i) {
            map1.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; ++i) {
            map2.put(list2[i], i);
        }
        
        int min = Integer.MAX_VALUE;
        Map<String, Integer> ansMap = new HashMap<>();
        for (String s : map1.keySet()) {
            if (map2.containsKey(s)) {
                min = Math.min(min, (map1.get(s) + map2.get(s)));
                ansMap.put(s, map1.get(s) + map2.get(s));
            }
        }
        
        List<String> list = new ArrayList<>();
        for (String s : ansMap.keySet()) {
            if (ansMap.get(s) == min) {
                list.add(s);
            }
        }
        String[] ans = new String[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}