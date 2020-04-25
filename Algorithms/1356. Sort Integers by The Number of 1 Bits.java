class Solution {
    public int[] sortByBits(int[] arr) {
        /*
            PriorityQueue
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        
        for (int i : arr) {
            int[] array = new int[2];
            array[0] = i;
            array[1] = ones(i);
            heap.add(array);
        }
        
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            ans[i] = heap.poll()[0];
        }
        
        return ans;
    }
    
    private int ones(int number) {
        int count = 0;
        while (number >= 1) {
            if (number % 2 == 1) {
                count++;
            }
            number /= 2;
        }
        
        return count;
    }
}