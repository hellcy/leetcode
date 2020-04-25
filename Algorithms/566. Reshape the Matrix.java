class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int[][] array = new int[r][c];
        int oldR = nums.length;
        int oldC = nums[0].length;
        if (oldR * oldC != r * c) return nums;
        
        for (int i = 0; i < r * c; ++i) {
            //System.out.println(i/c);
            //System.out.println(i - (int)(i / c) * c);
            //System.out.println(i / oldC);
            //System.out.println(i - (int)(i / oldC) * oldC);
            array[i / c][i - (int)(i / c) * c] = nums[i / oldC][i - (int)(i / oldC) * oldC];
        }
        
        return array;
    }
}