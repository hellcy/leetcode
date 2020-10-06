class Solution {
    public int specialArray(int[] nums) {
        int count = 0, x = 0;
        int max = 0;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        
        while (x <= max) {
            count = 0;
            for (int i : nums) {
                if (i >= x) count++;
            }
            
            if (count == x) return count;
            x++;
        }
        
        return -1;
    }
}