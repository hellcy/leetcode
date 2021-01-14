class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        /*
            sort
        */
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int ans = 0;
        int index = 0;
        while (truckSize > 0 && index < boxTypes.length) {
            if (truckSize >= boxTypes[index][0]) {
                ans += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
                index++;
            } else {
                ans += truckSize * boxTypes[index][1];
                break;
            }
        }

        return ans;

        /*
            HashMap
            Priority Queue
        */
        // Map<Integer, Integer> map = new HashMap<>();
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);

        // for (int[] box : boxTypes) {
        //     if (!map.containsKey(box[1])) {
        //         map.put(box[1], box[0]);
        //         pq.add(box[1]);
        //     } else {
        //         map.put(box[1], map.get(box[1]) + box[0]);
        //     }
        // }

        // int ans = 0;
        // while (truckSize > 0) {
        //     int num = pq.poll();
        //     if (truckSize >= map.get(num)) {
        //         ans += num * map.get(num);
        //         truckSize -= map.get(num);
        //     } else {
        //         ans += truckSize * num;
        //         break;
        //     }
        // }

        // return ans;
    }
}