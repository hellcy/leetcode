class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        /*
            Greedy
            
        */
        int x = 0, y = 0;
        int direction = 0;
        int max = 0;
        for (int i : commands) {
            if (i >= 1 && i <= 9) {
                int temp;
                switch(direction) {
                    case 0: 
                        temp = y;
                        y += i;
                        for (int j = 0; j < obstacles.length; ++j) {
                            if (obstacles[j][0] == x && obstacles[j][1] <= y && obstacles[j][1] > temp)
                                y = Math.min(y, obstacles[j][1] - 1);
                        }
                        break;
                    case 1:
                        temp = x;
                        x += i;
                        for (int j = 0; j < obstacles.length; ++j) {
                            if (obstacles[j][1] == y && obstacles[j][0] <= x && obstacles[j][0] > temp)
                                x = Math.min(x, obstacles[j][0] - 1);
                        }
                        break;
                    case 2: 
                        temp = y;
                        y -= i;
                        for (int j = 0; j < obstacles.length; ++j) {
                            if (obstacles[j][0] == x && obstacles[j][1] >= y && obstacles[j][1] < temp)
                                y = Math.max(y, obstacles[j][1] + 1);
                        }
                        break;
                    case 3:
                        temp = x;
                        x -= i;
                        for (int j = 0; j < obstacles.length; ++j) {
                            if (obstacles[j][1] == y && obstacles[j][0] >= x && obstacles[j][0] < temp)
                                x = Math.max(x, obstacles[j][0] + 1);
                        }
                        break;
                }
                //System.out.println(x + " " + y);
            } else if (i == -1) {
                direction++;
                direction = direction % 4;
            } else if (i == -2) {
                direction += 3;
                direction = direction % 4;
            }
            max = Math.max(max, x * x + y * y);
        }
        return max;
    }
}