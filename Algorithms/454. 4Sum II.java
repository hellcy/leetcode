class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        /*
            HashMap
                add all value combinations and its appearance times into a map
                for each value sum from c and d, if map contains -(c + d), add its value to the count
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a : A) {
            for (int b : B) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                if (map.containsKey(-(c + d))) count += map.get(-(c + d));
            }
        }
        return count;    
    }
}