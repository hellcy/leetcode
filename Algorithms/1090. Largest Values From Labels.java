class Solution {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        /*
            Priority Queue
            HashMap
                store values and labels into a priority queue based on values, the largest values at the front
                store labels and their use_limit into a map
                check each element in heap, if current element's label has use_limit > 0, we add it to sum
                return the sum when heap is empty or num_wanted <= 0
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        
        for (int i = 0; i < values.length; ++i) {
            int[] current = new int[2];
            current[0] = values[i];
            current[1] = labels[i];
            heap.add(current);
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : labels) {
            map.put(i, use_limit);
        }
        
        int sum = 0;
        while (!heap.isEmpty()) {
            int[] temp = heap.poll();
            //System.out.println(temp[0] + " " + temp[1]);
            if (num_wanted > 0 && map.get(temp[1]) > 0) {
                sum += temp[0];
                num_wanted--;
                map.put(temp[1], map.get(temp[1]) - 1);
            } 
            if (num_wanted <= 0) break;
        }
        
        return sum;
    }
}