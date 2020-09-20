class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {  
        /*
            cells are always 8
            1. save cells into a map with its index, cells can be seen as a binary number and convert into int.
            2. same cells will appear, so we need to detect circles
            3. get the reminder of N if N is too big
            4. convert the int back to its binray representation
        */
        
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        while (!map.containsKey(cellsToInt(cells)) && index < N) {
            int num = cellsToInt(cells);
            map.put(num, index);
            int[] newcells = changecells(cells);
            for (int i = 0; i < 8; ++i) {
                cells[i] = newcells[i];
            }
            
            index++;
        }
        
        int[] ans = new int[8];
        
        if (index == N) {
            return cells;
        }
        int circle = index - map.get(cellsToInt(cells));
        N = (N - index) % circle;

        int target = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == index - circle + N) target =  key;
        }
        
        ans = intToCells(target);
        
        return ans;
    }
    
    private int cellsToInt(int[] cells) {
        int ans = 0;
        int index = 0;
        for (int i = 7; i >= 0; --i) {
            if (cells[i] != 0) ans += Math.pow(2, index);
            index++;
        }
        
        return ans;
    }
    
    private int[] intToCells(int target) {
        int[] ans = new int[8];
        for (int i = 7; i>= 0; --i) {
            if (target % 2 == 0) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
            target = target / 2;
        }
        
        return ans;
    }
    
    private int[] changecells(int[] cells) {
        int[] newcells = new int[8];
        newcells[0] = 0;
        newcells[7] = 0;
        for (int i = 1; i < 7; ++i) {
            if (cells[i - 1] == cells[i + 1]) newcells[i] = 1;
            else newcells[i] = 0;
        }
        
        return newcells;
    }
    
}