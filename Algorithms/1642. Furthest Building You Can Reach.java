class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        int count = 0;
        for (int i = 1; i < heights.length; ++i) {
            if (heights[i] > heights[i - 1]) {
                int diff = heights[i] - heights[i - 1];
                if (pq.size() >= ladders) {
                    if (pq.size() > 0 && diff > pq.peek()) {
                        count += pq.poll();
                        pq.add(diff);
                    } else {
                        count += diff;
                    }
                    
                    if (count > bricks) {
                        return i - 1;
                    }
                } else {
                    pq.add(diff);
                }
            }
        }
        
        return heights.length - 1;
    }
}