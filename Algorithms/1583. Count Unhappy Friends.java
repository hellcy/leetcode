class Solution {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int count = 0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for (int[] pair : pairs) {
            map.put(pair[0], pair[1]);
            map.put(pair[1], pair[0]);
        }
        
        for (int key : map.keySet()) {
            for (int i : preferences[key]) {
                if (!map.containsKey(i)) continue;
                if (i == map.get(key)) break;
                if (ishappy(i, key, map.get(i), preferences)) continue;
                else {
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
    
    private boolean ishappy(int key, int a, int b, int[][] preferences) {
        boolean flag = false;
        for (int i : preferences[key]) {
            if (i == a) return false;
            else if (i == b) return true;
        }
        
        return false;
    }
}