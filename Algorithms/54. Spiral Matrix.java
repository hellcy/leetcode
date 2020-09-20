class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0) return list;
        int row = matrix.length, column = matrix[0].length;
        
        int[] topleft = {0, 0};
        int[] topright = {0, column - 1};
        int[] bottomleft = {row - 1, 0};
        int[] bottomright = {row - 1, column - 1};
                
        int count = 0, target = row * column;
        while (topleft[0] <= bottomleft[0] && topleft[1] <= topright[1] && count < target) {
            for (int i = topleft[1]; i < topright[1]; ++i) {
                list.add(matrix[topleft[0]][i]);
                count++;
                if (count >= target) return list;
            }
            if (count >= target) break;
            for (int i = topright[0]; i < bottomright[0]; ++i) {
                list.add(matrix[i][topright[1]]);
                count++;
                if (count >= target) return list;
            }
            if (count >= target) break;
            for (int i = bottomright[1]; i > bottomleft[1]; --i) {
                list.add(matrix[bottomright[0]][i]);
                count++;
                if (count >= target) return list;
            }
            if (count >= target) break;
            for (int i = bottomleft[0]; i > topleft[0]; --i) {
                list.add(matrix[i][bottomleft[1]]);
                count++;
                if (count >= target) return list;
            }
            
            // update all coors
            topleft[0]++;
            topleft[1]++;
            
            topright[0]++;
            topright[1]--;
            
            bottomright[0]--;
            bottomright[1]--;
            
            bottomleft[0]--;
            bottomleft[1]++;
            //System.out.println(topleft[0] + " " + bottomleft[0]  + " " + topleft[1] + " " + topright[1]);
            //System.out.println(count + " " + target);
        }
        
        if (row == column) list.add(matrix[row / 2][row / 2]);
        return list;
    }
}