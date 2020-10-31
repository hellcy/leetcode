class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ans = new ArrayList<>();
        
        int x = king[0], y = king[1];
        int currow = x;
        int curcol = y;
        
        // up
        while (currow >= 0) {
            if (helper(currow, curcol, ans, queens)) break;
            currow--;
        }
        
        // down
        currow = x;
        while (currow < 8) {
            if (helper(currow, curcol, ans, queens)) break;
            currow++;
        }
        
        // left
        currow = x;
        curcol = y;
        while (curcol >= 0) {
            if (helper(currow, curcol, ans, queens)) break;
            curcol--;
        }
        
        // right
        curcol = y;
        while (curcol < 8) {
            if (helper(currow, curcol, ans, queens)) break;
            curcol++;
        }
        
        // top-left
        curcol = y;
        currow = x;
        while (currow >= 0 && curcol >= 0) {
            if (helper(currow, curcol, ans, queens)) break;
            currow--;
            curcol--;
        }
        
        // bottom-right
        curcol = y;
        currow = x;
        while (currow < 8 && curcol < 8) {
            if (helper(currow, curcol, ans, queens)) break;
            currow++;
            curcol++;
        }
        
        // top-right
        curcol = y;
        currow = x;
        while (currow >= 0 && curcol < 8) {
            if (helper(currow, curcol, ans, queens)) break;
            currow--;
            curcol++;
        }
        
        // bottom-left
        curcol = y;
        currow = x;
        while (currow < 8 && curcol >= 0) {
            if (helper(currow, curcol, ans, queens)) break;
            currow++;
            curcol--;
        }
        
        return ans;
    }
    
    private boolean helper(int x, int y, List<List<Integer>> lists, int[][] queens) {
        boolean ans = false;
        for (int[] arr : queens) {
            if (arr[0] == x && arr[1] == y) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                lists.add(list);
                return true;
            }
        }
        return false;
    }
}