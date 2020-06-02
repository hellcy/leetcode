class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        
        int length = target.length;
        for (int i = 0; i < length; ++i) {
            map1.put(target[i], map1.getOrDefault(target[i], 0) + 1);
            map2.put(arr[i], map2.getOrDefault(arr[i], 0) + 1);
        }
        
        for (int i :  map1.keySet()) {
            if (!map2.containsKey(i)) return false;
            if (map1.get(i) != map2.get(i)) return false;
        }
        
        return true;
    }
}