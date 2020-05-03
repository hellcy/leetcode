class Solution {
    /*
        add Fibonacci numbers from the largest.
        Math prove can be found in discussion
    */
    int min = Integer.MAX_VALUE;
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        
        int first = 1;
        int second = 1;
        list.add(first);
        list.add(second);
        while (first + second <= k) {
            int next = first + second;
            list.add(next);
            first = second;
            second = next;
        }
        //System.out.println(list);
        int[] array = new int[list.size()];
        
        for (int i = 0; i < array.length; ++i) {
            array[i] = list.get(array.length - 1 - i);
        }
        
        int count = 0;
        int i =  0;
        while (k > 0) {
            count += (k / array[i]);
            k %= array[i];
            i++;
        }
        
        return count;
    }
}