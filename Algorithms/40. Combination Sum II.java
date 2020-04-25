class Solution {
    /*
        Backtracking
            remember to deal with the duplicate list like {1, 7} and {7, 1}
            sort them and check if lists already contain them
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        helper(new ArrayList<Integer>(), candidates, target, 0, 0);
        return lists;
    }
    
    private void helper(List<Integer> list, int[] candidates, int target, int index, int sum) {
        if (sum == target) {
            List<Integer> temp = new ArrayList<>(list);
            Collections.sort(temp);
            if (!lists.contains(temp)) lists.add(temp);
            return;
        }
        
        for (int i = index; i < candidates.length; ++i) {
            if (sum + candidates[i] > target) continue;
            list.add(candidates[i]);
            helper(list, candidates, target, i + 1, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}