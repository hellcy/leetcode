class Solution {
    public int maximumScore(int a, int b, int c) {
        /*
            pick the piles with the most stones
        */

        // int ans = 0;
        // int[] arr = {a, b, c};

        // while (true) {
        //     Arrays.sort(arr);
        //     if (arr[1] < 1) break;
        //     arr[1]--;
        //     arr[2]--;
        //     ans++;
        // }
        // return ans;

        /*
            Heap
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int ans = 0;
        pq.add(a);
        pq.add(b);
        pq.add(c);
        while (true) {
            int first = pq.poll();
            int second = pq.poll();
            if (second < 1) break;
            first--;
            second--;
            pq.add(first);
            pq.add(second);
            ans++;
        }

        return ans;
    }
}