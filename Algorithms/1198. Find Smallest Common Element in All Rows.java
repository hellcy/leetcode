class Solution {
    public int smallestCommonElement(int[][] mat) {
        /*
            HashMap
                store all values into a map, check the times of appearance
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < mat.length; ++i) {
            for (int j = 0; j < mat[0].length; ++j) {
                map.put(mat[i][j], map.getOrDefault(mat[i][j], 0) + 1);
            }
        }
        
        //System.out.println(map + " " + mat.length);
        for (int i : map.keySet()) {
            if (map.get(i) == mat.length) {
                return i;
            }
        }
        
        return -1;
    }
}