class Solution {
    public int eatenApples(int[] apples, int[] days) {
        /*
            Priority Queue + HashMap
        */
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);

        int n = apples.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            int expiryday = i + days[i];
            if (!map.containsKey(expiryday)) {
                map.put(expiryday, apples[i]);
                pq.add(expiryday);
            }

            while (!pq.isEmpty()) {
                int smallest = pq.peek();
                if (smallest - i - 1 >= 0) {
                    ans++;
                    map.put(smallest, map.get(smallest) - 1);
                    if (map.get(smallest) == 0) {
                        map.remove(smallest);
                        pq.remove(smallest);
                    }
                    break;
                } else {
                    pq.remove(smallest);
                    map.remove(smallest);
                }
            }
        }

        while (!pq.isEmpty()) {
            int smallest = pq.peek();
            if (smallest - n - 1 >= 0) {
                ans++;
                n++;
                map.put(smallest, map.get(smallest) - 1);
                if (map.get(smallest) == 0) {
                    map.remove(smallest);
                    pq.remove(smallest);
                }
            } else {
                pq.remove(smallest);
                map.remove(smallest);
            }
        }
        
        return ans;
        
        /*
            TLE
            Priority Queue
        */
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> x - y);
        // int n = apples.length;
        // int ans = 0;
        // for (int i = 0; i < n; ++i) {
        //     for (int j = 0; j < apples[i]; ++j) {
        //         queue.add(i + days[i]);
        //     }

        //     while (!queue.isEmpty()) {
        //         int num = queue.poll();
        //         if (num - i - 1 >= 0) {
        //             ans++;
        //             break;
        //         }
        //     }
        // }

        // while (!queue.isEmpty()) {
        //     int num = queue.poll();
        //     if (num - n - 1 >= 0) {
        //         ans++;
        //         n++;
        //     }
        // }

        // return ans;
    }
}