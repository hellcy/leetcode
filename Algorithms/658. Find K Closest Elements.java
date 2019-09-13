class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        /*
            Priority Queue
                sort element by their absolute difference to the target value
                if distance to target are the same, then sort by their value
                then add these values to a list and sort
        */
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> Math.abs(b - x) == Math.abs(a - x) ? b - a : Math.abs(b - x) - Math.abs(a - x));
        
        for (int i = arr.length - 1; i >= 0; --i) {
            heap.add(arr[i]);
            //System.out.println(heap);

            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> list = new ArrayList<>();
        
        for (int i : heap) {
            list.add(i);
        }
        Collections.sort(list);
        return list;
    }
}