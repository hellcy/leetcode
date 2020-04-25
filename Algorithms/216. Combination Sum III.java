class Solution {
    /*
        Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        
        helper(new ArrayList<Integer>(), k, n, 0, 1);
        return lists;
    }
    
    private void helper(List<Integer> list, int k, int n, int sum, int index) {
        if (list.size() == k && sum == n) {
            lists.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < 10; ++i) {
            if (sum + i > n) continue;
            list.add(i);
            helper(list, k, n, sum + i, i + 1);
            list.remove(list.size() - 1);
        }
    }
}