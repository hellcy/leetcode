class Solution {
    public int minKnightMoves(int x, int y) {
        /*
            BFS
            1. we can only get the positive value of x and y, it doesn't affect the result
            2. we need to encode the x and y to a single integer to run faster, we shift x to the right by 10 bits then add y
            3. to decode single integer to x and y, we shift the integer to the left by 10 bits to get x, then use integer - (x<<10) to get y
        */
        
        Set<Integer> visited = new HashSet<>();
        x = Math.abs(x); y = Math.abs(y);
        int[] directionx = {1,2,2,1,-1,-2,-2,-1};
        int[] directiony = {2,1,-1,-2,-2,-1,1,2};
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(0);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                Integer current = queue.poll();
                int curx = (current>>10);
                int cury = current - (curx<<10);
                if (curx == x && cury == y) return step;

                for (int i = 0; i < 8; ++i) {
                    int newx = curx + directionx[i];
                    int newy = cury + directiony[i];
                    
                    int newint = ((newx<<10) + newy);
                    if (visited.contains(newint)) continue;
                    queue.add(newint);
                    visited.add(newint);
                }
            }
            step++;
        }
        
        return -1;
    }

}