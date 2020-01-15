class Solution {
    /*
        matrix brute force
        sum all valid numbers 
    */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int r = mat.length;
        int c = mat[0].length;
        
        int[][] answer = new int[r][c];
        
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                
                for (int a = i - K; a <= i + K; ++a) {
                    for (int b = j - K; b <= j + K; ++b) {
                        if (a >= 0 && b >= 0 && a < r && b < c) {
                            answer[i][j] += mat[a][b];
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}