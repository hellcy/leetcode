class Solution {
    /*
        Backtracking
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        
        helper(new ArrayList<Integer>(), 1, n, k);
        return lists;
    }
    
    private void helper(List<Integer> list, int count, int n, int k) {
        //System.out.println(list + " " + count);
        if (list.size() == k) {
            lists.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = count; i <= n; ++i) {
            list.add(i);
            helper(list, i + 1, n, k);
            list.remove(list.size() - 1);
        }
    }
}