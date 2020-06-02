class Solution {
    /*
        Trie + DFS
        1. Implement Trie structrure with insert, find and find prefix functions
        2. dfs on each board cell
        3. keep track of visited characters, remember to change it to false when backtracking
    */
    public List<String> findWords(char[][] board, String[] words) {
        /*
            Trie + DFS
        */
        Trie head = new Trie();
        Trie current = head;
        for (String str : words) {
            current = head;
            for (char c : str.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    Trie temp = new Trie();
                    current.children[c - 'a'] = temp;
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
        }
        
        
        List<String> list = new ArrayList<>();
        if (board == null || board.length == 0) return list;
        
        int row = board.length, column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                dfs(head, i, j, board, "", list, visited);
            }
        }
        
        return list;
    }
    
    public class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;
        Trie() {
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }
    
    private boolean find(Trie head, String s) {
        Trie current = head;
        for (char c : s.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return current.isEnd;
    }
    
    private boolean findPrefix(Trie head, String s) {
        Trie current = head;
        for (char c : s.toCharArray()) {
            if (current.children[c - 'a'] == null) return false;
            current = current.children[c - 'a'];
        }
        return true;
    }
    
    private void dfs(Trie head, int x, int y, char[][] board, String word, List<String> list, boolean[][] visited) {
        if (findPrefix(head, word)) {
            word = word + String.valueOf(board[x][y]);
            if (find(head, word) && !list.contains(word)) {
                list.add(word);
            }
            
            int[] directionx  = {-1, 0, 1, 0};
            int[] directiony = {0, 1, 0, -1};
            int row = board.length, column = board[0].length;
            
            for (int i = 0; i < 4; ++i) {
                int coorx = x + directionx[i];
                int coory = y + directiony[i];
                if (coorx < 0 || coorx >= row || coory < 0 || coory >= column || visited[coorx][coory]) continue;
                visited[x][y] = true;
                dfs(head, coorx, coory, board, word, list, visited);
                visited[x][y] = false;
            }
        }
    }
}