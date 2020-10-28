class Solution {
    public boolean isPathCrossing(String path) {
        char[] cs = path.toCharArray();
        
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        
        int x = 0, y = 0;
        Pair<Integer, Integer> pair = new Pair<>(x, y);
        set.add(pair);
        
        for (char c : cs) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x--;
            } else if (c == 'W') {
                x++;
            }
            
            Pair<Integer, Integer> temp = new Pair<>(x, y);
            
            if (set.contains(temp)) return true;
            else set.add(temp);
        }
        
        return false;
    }
}