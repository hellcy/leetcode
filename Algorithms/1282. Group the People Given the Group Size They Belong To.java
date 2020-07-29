class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        /*
            HashMap
            List
        */
        List<List<Integer>> lists = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; ++i) {
            if (!map.containsKey(groupSizes[i])) {
                List<Integer> list = new ArrayList<>();
                map.put(groupSizes[i], list);
            }
            List<Integer> list2 = map.get(groupSizes[i]);
            list2.add(i);
            if (list2.size() == groupSizes[i]) {
                lists.add(list2);
                map.remove(groupSizes[i]);
            }
        }
        
        return lists;
    }
}