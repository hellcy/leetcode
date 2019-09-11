class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {  
        /*
            HashMap
            Priority Queue
                Create a map to store all pairs and their sums
                Traverse the map, only keep the k smallest pairs in the heap
                Add pair from heap to a list, and reverse it
        */
        Map<int[], Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums1.length; ++i) {
            for (int j = 0; j < nums2.length; ++j) {
                int[] temp = new int[2];
                temp[0] = nums1[i];
                temp[1] = nums2[j];
                map.put(temp, nums1[i] + nums2[j]);
            }
        }
        
        //System.out.println(map);
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        
        for (int[] array : map.keySet()) {
            heap.add(array);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        
        while (!heap.isEmpty()) {
            ans.add(Arrays.stream(heap.poll()).boxed().collect(Collectors.toList()));
        }
        
        Collections.reverse(ans);
        return ans;
    }
}