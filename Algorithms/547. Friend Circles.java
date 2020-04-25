class Solution {
    /*
        DFS
    */
    int count = 0;
    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        
        int row = M.length;
        boolean[] visited = new boolean[row];
        for (int i = 0; i < row; ++i) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
            visited[i] = true;
        }
        
        return count;
    }
    
    private void dfs(int[][] M, boolean[] visited, int rowindex) {
        //System.out.println(start);
        for (int i = 0; i < M[0].length; ++i) {
            if (M[rowindex][i] == 0) continue;
            if (visited[i]) continue;
            visited[i] = true;
            dfs(M, visited, i);
        }
    }
}