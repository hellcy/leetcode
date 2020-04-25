class Solution {
    public int[][] highFive(int[][] items) {
        /*
            HashMap
            PriorityQueue
        */
        Map<Integer, Integer> time = new HashMap<>();
        Map<Integer, Integer> score = new HashMap<>();
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        int number = items.length;
        for (int i = 0; i < number; ++i) {
            heap.add(items[i]);
        }
        
        while (!heap.isEmpty()) {
            int[] temp = heap.poll();
            if (time.getOrDefault(temp[0], 0) < 5) {
                score.put(temp[0], score.getOrDefault(temp[0], 0) + temp[1]);
                time.put(temp[0], time.getOrDefault(temp[0], 0) + 1);
            }
        }
        
        int[][] ans = new int[score.size()][2];
        for (int i = 0; i < ans.length; ++i) {
            ans[i][0] = i + 1;
            ans[i][1] = score.get(i + 1) / 5;
        }
        
        return ans;
    }
}