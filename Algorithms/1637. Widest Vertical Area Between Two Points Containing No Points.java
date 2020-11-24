class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        Arrays.sort(points, new Comparator<int[]>() {
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           } 
        });
        
        for (int i = 1; i < points.length; ++i) {
            max = Math.max(max, Math.abs(points[i - 1][0] - points[i][0]));    
        }
        
        return max;
    }
}