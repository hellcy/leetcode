class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans = -1;
        int n = points.length;
        int index = 0;
        int dis = Integer.MAX_VALUE;
        for (int[] point : points) {
            int cur = checkDis(x, y, point);
            if (checkValid(x, y, point) && dis > cur) {
                dis = cur;
                ans = index;
            }
            index++;
        }

        return ans;
    }

    private boolean checkValid(int x, int y, int[] point) {
        if (point[0] == x || point[1] == y) return true;
        else return false;
    }

    private int checkDis(int x, int y, int[] point) {
        return Math.abs(point[0] - x) + Math.abs(point[1] - y);
    }
}