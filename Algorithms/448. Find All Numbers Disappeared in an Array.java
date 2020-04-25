class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /*
            algorithm explained:
                create a new array with size + 1
                move values to its correct place in the new array
                add index with value zero to the list
        */
        int[] array = new int[nums.length + 1];
        List<Integer> list = new ArrayList<>();        
        
        for (int i = 0; i < nums.length; ++i) {
            array[nums[i]] = nums[i];
        }
        
        for (int i = 1; i <array.length; ++i) {
            if (array[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}