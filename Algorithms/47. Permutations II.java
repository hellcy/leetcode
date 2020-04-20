class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        /*
            BackTracking
            Similar to permutation 1
            when we want to add a duplicate number, if its previous duplicate was not visited, then we skip it
        */
        List<List<Integer>> lists = new ArrayList<>();
        
        if (nums == null || nums.length == 0) return lists;
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        helper(nums, lists, new ArrayList<>(), visited);
        return lists;
    }
    
    private void helper(int[] nums, List<List<Integer>> lists, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (visited[i]) continue;
                if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
                visited[i] = true;
                list.add(nums[i]);
                helper(nums, lists, list, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}