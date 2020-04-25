class Solution {
    public String convert(String s, int numRows) {
        /*
            Two dimensional char array
            Default value of char array
            String Builder
        */
        int length = s.length();
        if (numRows == 1) return s;
        int rest = length % (numRows * 2 - 2);
        int group = length / (numRows * 2 - 2) + (rest > 0 ? 1 : 0);
        //System.out.println(rest + " " + group);
        char[][] matrix = new char[group][numRows * 2 - 2];
        int k = 0;
        for (int i = 0; i < group; ++i) {
            for (int j = 0; j < numRows * 2 - 2; ++j) {
                matrix[i][j] = s.charAt(k);
                k++;
                if (k == length) break;
            }
        }
        //System.out.println(matrix[0]);
        StringBuilder ans = new StringBuilder();
        
        for (int i = 0; i <= (numRows * 2 - 2) / 2; ++i) {
            for (int j = 0; j < group; ++j) {
                if (i != 0 && i != matrix[0].length - i) {
                    if (matrix[j][i] != 0) ans.append(matrix[j][i]);
                    if (matrix[j][matrix[0].length - i] != 0) ans.append(matrix[j][matrix[0].length - i]);
                } else {
                    if (matrix[j][i] != 0) ans.append(matrix[j][i]);
                }
            }
        }
        return ans.toString();
    }
}