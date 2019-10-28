class Solution {
    /*
        Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        helper(nums, new ArrayList<Integer>(), 0);
                
        return lists;
    }
    
    private void helper(int[] nums, List<Integer> list, int count) {
        //System.out.println(list + " " + count);     
        lists.add(new ArrayList<>(list));
        
        for (int i = count; i < nums.length; ++i) {
            list.add(nums[i]);
            helper(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}