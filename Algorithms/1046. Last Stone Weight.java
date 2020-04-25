class Solution {
    public int lastStoneWeight(int[] stones) {
        /*
            Priority Queue
                prioritise values to greatest at the top by using regular expression
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>((x, y) -> y - x);
        
        for (int i : stones) {
            heap.add(i);
        }
        
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) heap.add(Math.abs(x - y));
        }
        
        if (heap.size() == 1) return heap.poll();
        else return 0;
    }
}