class Solution {
    /*
        Backtracking
            deep copy list and set
    */
//     List<List<Integer>> lists = new ArrayList<>();
//     public List<List<Integer>> permute(int[] nums) {
//         Set<Integer> set = new HashSet<>();
        
//         for (int i : nums) {
//             set.add(i);
//         }
//         List<Integer> list = new ArrayList<>();
//         helper(list, set, nums.length);
//         return lists;
//     }
    
//     private void helper(List<Integer> list, Set<Integer> set, int length) {
//         //System.out.println(list + " " + set);
//         if (list.size() == length) {
//             lists.add(list);
//             return;
//         }
        

//         for (int i : set) {
//             List<Integer> temp = new ArrayList<>(list);
//             temp.add(i);
//             Set<Integer> set2 = new HashSet<Integer>(set);
//             set2.remove(i);
//             helper(temp, set2, length);
//         }
//     }
    
    /*
        Better Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(new ArrayList<Integer>(), nums, 0);
        return lists;
    }
    
    private void helper(List<Integer> list, int[] nums, int index) {
        //System.out.println(list);
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < nums.length; ++i) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(list, nums, 0);
            list.remove(list.size() - 1);
        }
    }
}