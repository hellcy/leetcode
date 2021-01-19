class Solution {
    public int largestSubmatrix(int[][] matrix) {
        /*
            Convert the matrix so that Matrix[i][j] is the sum of continous 1's upto ith row in the column number j.
            If the element in that cell is 1 add it to the previous streak else make it 0.
            Then find the maximum area upto ith row. To do this first sort the ith row in descending order.
            Now minimum upto jth column * (j+1) will be the area, the maximum of all these is the final answer.

            Note: 
            Arrays.sort() cannot be used directly to sort primitive arrays in descending order. 
            If you try to call the Arrays.sort() method by passing reverse Comparator defined by Collections.reverseOrder() , 
            it will throw the error no suitable method found for sort(int[],comparator)
            That will work fine with 'Array of Objects' such as Integer array but will not work with a primitive array such as int array.
            The only way to sort a primitive array in descending order is, first sort the array in ascending order 
            and then reverse the array in place. This is also true for two-dimensional primitive arrays.
        */

        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 1; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == 1) matrix[i][j] += matrix[i - 1][j];
            }
        }

        int ans = 0;
        for (int i = 0; i < row; ++i) {
            Arrays.sort(matrix[i]);
            reverse(matrix[i]);

            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int j = 0; j < col; ++j) {
                min = Math.min(min, matrix[i][j]);
                max = Math.max(max, (j + 1) * min);
            }

            ans = Math.max(ans, max);
        }

        return ans;
    }

    private void reverse(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n / 2; ++i) {
            int temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}