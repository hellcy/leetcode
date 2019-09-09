class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
            Priority queue
                it can order the elements in it by certain comparator rules or by natural order
                when init pq, we pass the regular expression, it means let the pq to sort the elements by the smallest value in map goes first
                only keep k elements in the pq, so the value with less frequencies will be removed
                add pq to a list, but now the least frequency is at front, so reverse the list
        */
        // build hash map : character and how often it appears
        HashMap<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> count.get(n1) - count.get(n2));

        //System.out.println(count);
        // keep k top frequent elements in the heap
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
            //System.out.println(heap);
        }

        // build output list
        List<Integer> top_k = new LinkedList();
        while (!heap.isEmpty())
          top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;
    }
}