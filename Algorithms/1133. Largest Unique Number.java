class Solution {
    public int largestUniqueNumber(int[] A) {
        /*
            HashMap
        */
        int max = Integer.MIN_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : A) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() == 1) {
                if (max < (int)entry.getKey()) max = (int)entry.getKey();
            }
        }
        
        if (max == Integer.MIN_VALUE) return -1;
        
        return max;
    }
}