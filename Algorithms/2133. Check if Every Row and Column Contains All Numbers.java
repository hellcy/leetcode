class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        
        // for each row
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j : matrix[i]) {
                set.add(j);
            }
            
            if (set.size() != n) return false;
        }
        
        // for each column
        for (int i = 0; i < n; ++i) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                set.add(matrix[j][i]);
            }
            
            if (set.size() != n) return false;
        }
        
        return true;
    }
}