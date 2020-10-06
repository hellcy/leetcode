class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        /*
            Single scan
            1. store min so far and max so far
            2. compare with each new array
        */
        List<Integer> first = arrays.get(0);
        int min = first.get(0);
        int max = first.get(first.size() - 1);
        
        int index = 0;
        int distance = 0;
        for (List<Integer> list : arrays) {
            if (index == 0) {
                index++;
                continue;
            }
            distance = Math.max(distance, max - list.get(0));
            distance = Math.max(distance, list.get(list.size() - 1) - min);
            
            min = Math.min(min, list.get(0));
            max = Math.max(max, list.get(list.size() - 1));
        }
        
        return distance;
    }
}