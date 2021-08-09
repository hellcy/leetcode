class Solution {
    public int minStoneSum(int[] piles, int k) {
        // pq
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        
        for (int i : piles) {
            pq.add(i);
        }
        
        while (k > 0) {
            int num = pq.poll();
            num = num % 2 == 0 ? num / 2 : num / 2 + 1;
            pq.add(num);
            k--;
        }
        
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        
        return ans;
    }
}