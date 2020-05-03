/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        /*
            find the leftmost one for the current row, then going down until find another one, then going left....
            
            O (n) time
        */
        List<Integer> dimension = binaryMatrix.dimensions();
        int row = dimension.get(0);
        int column = dimension.get(1);
        
        int start = 0, end = column - 1;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            
            int value = binaryMatrix.get(0, mid);
            if (value == 1) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        int min = column;
        boolean flag = false;
        if (binaryMatrix.get(0, start) == 1) min = start;
        else if (binaryMatrix.get(0, end) == 1) min = end;
        else {
            flag = true;
            min = end;
        }
        //System.out.println(min);
        int rownumber = 1;
        boolean isrow = false;
        while (rownumber < row && min >= 0) {
            while (rownumber < row && binaryMatrix.get(rownumber, min) == 0) {
                rownumber++;
            }
            if (rownumber < row) {
                 while (min >= 0 && binaryMatrix.get(rownumber, min) == 1) {
                    min--;
                    isrow = true;
                }   
            }
        }
        
        if (min == end && flag) return -1;
        if (isrow) return min + 1;
        else return min;
        
        
        /*
            Binary search
            perform binary search on each row to find the smallest index of one
            O (nlogn) time
        */
        
//         List<Integer> dimension = binaryMatrix.dimensions();
//         int row = dimension.get(0), column = dimension.get(1);
//         int min = column;
//         for (int i = 0; i < row; ++i) {
//             int start = 0, end = column - 1;
//             while (start + 1 < end) {
//                 int mid = (end - start) / 2 + start;
//                 int value = binaryMatrix.get(i, mid);
//                 if (value == 1) {
//                     end = mid;
//                 } else {
//                     start = mid;
//                 }
//             }
//             if (binaryMatrix.get(i, start) == 1) {
//                 if (start < min) min = start;
//             } 
//             else if (binaryMatrix.get(i, end) == 1) {
//                 if (end < min) min = end;
//             }
//         }
//         if (min == column) return -1;
//         return min;
    }
}