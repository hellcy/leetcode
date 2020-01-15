class Solution {
    /*
        array
        list
        list to array
    */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        int first = 0, second = 0;
        int size = 0;
        for (int i = 0; i < nums.length - 1; i = i + 2) {
            first = nums[i];
            second = nums[i + 1];
            size += first;
            for (int j = first; j > 0; --j) {
                list.add(second);
            }
        }
        
        int[] result = new int[size];
        
        for (int i = 0; i < size; ++i) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}