class Solution {
    /*
        Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            // because we can use one candidate multiple times, we check if sum greater than target
            // if it is, finish the helper and let index++
            //System.out.println(list);
            if (sum + candidates[i] > target) return; 
            list.add(candidates[i]);
            helper(list, candidates, target, 0, sum + candidates[i]);
            list.remove(list.size() - 1);
        }
        
    }
}