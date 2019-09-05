class Solution {
    public int repeatedNTimes(int[] A) {
        /*
            Hash map
                store A in a map
                if A already contains the key, we know it is the element
                return the element
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : A) {
            if (map.containsKey(i)) return i;
            else map.put(i, 1);
        }
        
        throw null;
    }
}