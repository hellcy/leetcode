class Solution {
    public int findSpecialInteger(int[] arr) {
        /*
            Map
        */
        int length = arr.length;
        int number = length / 4 + 1;
        int count = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry entry : map.entrySet()) {
            if (number <= (int)entry.getValue()) {
                return (int)entry.getKey();
            }
        }
        
        throw null;
    }
}