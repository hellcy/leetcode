class Solution {
    public List<List<String>> solveNQueens(int n) {
        /*
            DFS
            Backtracking
            1. Use a List of Integers to store queens coordinates, list values are the column number of a queen, list indexes are the row number of a queen
            2. everytime when we are inserting a new queen into the list, we need to check which column index is valid for the new queen to be inserted in the current row
            3. we check every column index. A column index is valid if the list doesn't have a same index. And diagonals doesn't have queens.
            4. for checking diagonals, we need to check previous saved queens x + y != new queen x + y. And previous x - y != new x - y
            5. after found a valid board, convert it from List of Integer to List of String
        */
        List<List<String>> lists = new ArrayList<>();
        if (n <= 0) return lists;
        
        helper(lists, new ArrayList<Integer>(), n);
        return lists;
    }
    
    private void helper(List<List<String>> lists, List<Integer> columns, int n) {
        if (columns.size() == n) {
            List<String> list = drawboard(columns);
            lists.add(list);
        } else {
            for (int i = 0; i < n; ++i) {
                if (!isvalid(columns, i)) continue;
                
                columns.add(i);
                helper(lists, columns, n);
                columns.remove(columns.size() - 1);
            }
        }
    }
    
    private boolean isvalid(List<Integer> cols, int colindex) {
        int currentrow = cols.size();
        
        for (int rowindex = 0; rowindex < currentrow; ++rowindex) {
            if (cols.get(rowindex) == colindex) return false;
            else if (currentrow + colindex == rowindex + cols.get(rowindex)) return false;
            else if (currentrow - colindex == rowindex - cols.get(rowindex)) return false;
        }
        
        return true;
    }
    
    private List<String> drawboard(List<Integer> columns) {
        List<String> list = new ArrayList<>();
        int length = columns.size();
        for (int i = 0; i < length; ++i) {
            String str = "";
            int index = columns.get(i);
            int right = length - index - 1;
            int left = length - right - 1;
            for (int j = 0; j < left; ++j) {
                str += ".";
            }
            str += "Q";
            for (int j = 0; j < right; ++j) {
                str += ".";
            }
            list.add(str);
        }
        return list;
    }
}