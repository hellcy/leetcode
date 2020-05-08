class Solution {
    public int nthUglyNumber(int n) {
        /*
            Dynamic programming
                the next ugly number can only be 2, 3 or 5 multiple by a previous ugly number.
                because ugly numbers are sorted, everytime we pick the smallest number possible
                
                the first ugly number is 1.
                
                so next possible ugly numbers are: 1 * 2, 1 * 3, 1 * 5 => 2, 3, 5
                we pick 2 since its the smallest, now the list: 1, 2
                
                next possible ugly numbers are: 1 * 3, 1 * 5, 2 * 2, 2 * 3, 2 * 5 => 3, 5, 4, 6, 10
                we pick the smallest number 3, now the list: 1,2,3
                
                next possible ugly numbers are: 5,4,6,10, 3 * 2, 3 * 3, 3 * 5 = > 5,4,6,10,9,15
                we pick 4....
                
        */
//         int two = 0, three = 0, five = 0;
        
//         if (n == 0) return 0;
//         int[] array = new int[n];
//         array[0] = 1;
        
//         for (int i = 1; i < array.length; ++i) {
//             int number = Math.min(array[two] * 2, Math.min(array[three] * 3, array[five] * 5));
            
//             array[i] = number;
            
//             if (number == array[two] * 2) two++;
//             if (number == array[three] * 3) three++;
//             if (number == array[five] * 5) five++;
//         }
        
//         return array[n - 1];
        
        /*
            Priority Queue
        */
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Set<Long>  set = new HashSet<>();
        
        heap.add(Long.valueOf(1));
        set.add(Long.valueOf(1));
        
        int[] array = new int[3];
        array[0] = 2;
        array[1] = 3;
        array[2] = 5;
        
        Long number = Long.valueOf(1);
        for (int i = 0; i < n; ++i) {
            number = heap.poll();
            for (int j = 0; j < 3; ++j) {
                if (!set.contains(number * array[j])) {
                    set.add(number * array[j]);
                    heap.add(number * array[j]);
                }
            }
        }
        
        return number.intValue();
    }
}