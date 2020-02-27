class Solution {
    /*
        2D array
    */
    int[][] matrix = new int[3][3];
    public String tictactoe(int[][] moves) {
        for (int i = 0; i < moves.length; ++i) {
            if (i % 2 == 0) {
                matrix[moves[i][0]][moves[i][1]] = 1;
            } else {
                matrix[moves[i][0]][moves[i][1]] = 2;
            }
        }
        
        if (checkwin(1)) return "A";
        if (checkwin(2)) return "B";
        if (moves.length < 9) return "Pending";
        else return "Draw";
    }
    
    private boolean checkwin(int x) {
        int count = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (matrix[i][j] == x) count++;
                if (count == 3) return true;
            }
            count = 0;
        }
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (matrix[j][i] == x) count++;
                if (count == 3) return true;
            }
            count = 0;
        }
        
        if (matrix[0][0] == x && matrix[1][1] == x && matrix[2][2] == x) return true;
        if (matrix[0][2] == x && matrix[1][1] == x && matrix[2][0] == x) return true;
        
        return false;
    }
}