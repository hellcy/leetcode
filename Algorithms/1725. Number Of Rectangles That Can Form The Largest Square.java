class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int n = rectangles.length;
        
        int[] arr = new int[n];
        int index = 0;
        for (int[] rectangle : rectangles) {
            arr[index] = Math.min(rectangle[0], rectangle[1]);
            index++;
        }
        
        int ans = 0;
        int max = -1;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        
        for (int i : arr) {
            if (i == max) {
                ans++;
            }
        }
        
        return ans;
    }
}