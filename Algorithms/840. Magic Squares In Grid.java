class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        /*
            brute force
        */
        int r = grid.length;
        int c = grid[0].length;
        if (r < 3 || c < 3) return 0;
        int count = 0;
        for (int x = 0; x <= r - 3; ++x) {
            for (int y = 0; y <= c - 3; ++y) {
                if (check(grid, x, y)) count++;
            }
        }
        return count;
    }
    
    private boolean check(int[][] grid, int i, int j) {
        Set<Integer> set = new HashSet<>();
        int sum = grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2];
        if (sum != grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j]) return false;
        int row = 0;
        int column = 0;
        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                if (grid[i + x][j + y] < 1 || grid[i + x][j + y] > 9 || set.contains(grid[i + x][j + y])) return false;
                set.add(grid[i + x][j + y]);
                row += grid[i + x][j + y];
                column += grid[i + y][j + x];
            }
            if (row != sum || column != sum) return false;
            row = 0;
            column = 0;
        }
        return true;
    }
}