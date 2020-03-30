class Solution {
    public int getKth(int lo, int hi, int k) {
        /*
            PriorityQueue
        */
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        
        for (int i = lo; i <= hi; ++i) {
            int[] array = new int[2];
            array[0] = i;
            int temp = i;
            int count = 0;
            while (temp != 1) {
                count++;
                if (temp % 2 == 0) temp /= 2;
                else temp = temp * 3 + 1;
            }
            array[1] = count;
            heap.add(array);
        }
        
        int ans = 0;
        while (k != 0) {
           ans = heap.poll()[0];
            k--;
        }
        return ans;
    }
}