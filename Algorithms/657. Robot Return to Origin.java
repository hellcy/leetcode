class Solution {
    public boolean judgeCircle(String moves) {
        /*
            hashMap
        */
//         Map<Character, Integer> map = new HashMap<>();
        
//         char[] cs = moves.toCharArray();
        
//         for (char c : cs) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
        
//         int left = 0, right = 0, up = 0, down = 0;
        
//         if (map.get('L') != null) left = map.get('L');
//         if (map.get('R') != null) right = map.get('R');
//         if (map.get('U') != null) up = map.get('U');
//         if (map.get('D') != null) down = map.get('D');
        
//         if (left != right || up != down) return false;
//         else return true;
        
        /*
            Simulation
        */
        
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
}