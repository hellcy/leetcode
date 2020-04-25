class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        /*
            Array
            Math 
                slope of a line
                need to check when slope is infinite (denominator is zero)
        */
        if (coordinates[0][1] - coordinates[1][1] == 0) {
            for (int i = 1; i < coordinates.length; ++i) {
                if (coordinates[i - 1][1] != coordinates[i][1]) return false;
            }
            return true;
        } else {
                 int slope = (coordinates[0][0] - coordinates[1][0]) / (coordinates[0][1] - coordinates[1][1]);
            for (int i = 2; i < coordinates.length; ++i) {
                if (coordinates[i - 1][1] - coordinates[i][1] == 0) return false;
                if (slope != (coordinates[i - 1][0] - coordinates[i][0]) / (coordinates[i - 1][1] - coordinates[i][1])) {
                    return false;
                }
            }
        
            return true;   
        }
    }
}