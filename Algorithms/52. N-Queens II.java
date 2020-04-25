class Solution {
    /*
        DFS
        Backtracking
        similar to n-queens
        1. Use a List of Integers to store queens coordinates, list values are the column number of a queen, list indexes are the row number of a queen
        2. everytime when we are inserting a new queen into the list, we need to check which column index is valid for the new queen to be inserted in the current row
        3. we check every column index. A column index is valid if the list doesn't have a same index. And diagonals doesn't have queens.
        4. for checking diagonals, we need to check previous saved queens x + y != new queen x + y. And previous x - y != new x - y
        5. count plus one for each valid board
    */
    int count = 0;
    public int totalNQueens(int n) {
        if (n <= 0) return 0;
        
        helper(new ArrayList<Integer>(), n);
        return count;
    }
    
    private void helper(List<Integer> cols, int n) {
        if (cols.size() == n) {
            count++;
        } else {
            for (int i = 0; i < n; ++i) {
                if (!isvalid(cols, i)) continue;
                
                cols.add(i);
                helper(cols, n);
                cols.remove(cols.size() - 1);
            }
        }
    }
    
    private boolean isvalid(List<Integer> cols, int colindex) {
        int currentrow = cols.size();
        for (int rowindex = 0; rowindex < currentrow; ++rowindex) {
            if (cols.get(rowindex) == colindex) return false;
            else if (rowindex + cols.get(rowindex) == colindex + currentrow) return false;
            else if (rowindex - cols.get(rowindex) == currentrow - colindex) return false;
        }
        
        return true;
    }
}