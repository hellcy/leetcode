class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        /*
            HashMap
            Set
        */
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int prev = 0;
        //System.out.println(map);
        for (int i : map.keySet()) {
            if (!set.contains(map.get(i))) {
                set.add(map.get(i));   
            } else return false;
        }
        
        return true;
    }
}