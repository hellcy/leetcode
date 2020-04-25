class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        /*
            HashMap
                store index information of B
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < B.length; ++i) {
            map.put(B[i], i);
        }
        
        int[] array = new int[A.length];
        for (int i = 0; i < A.length; ++i) {
            array[i] = map.get(A[i]);
        }
        
        return array;
    }
}