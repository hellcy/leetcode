class Solution {
    /*
        List
        Set
        Recursion
    */
    List<List<Integer>> lists = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        lists = rooms;
        for (int i = 1; i < lists.size(); ++i) {
            set.add(i);
        }
        
        helper(lists.get(0), 0);
        if (set.size() == 0) return true;
        else return false;
    }
    
    private void helper(List<Integer> list, int room) {
        set.remove(room);
        for (int i : list) {
            if (set.contains(i) && i != room) {
                helper(lists.get(i), i);
            }
        }
        
    }
}