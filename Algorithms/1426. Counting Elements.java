class Solution {
    public int countElements(int[] arr) {
        /*
            HashMap
            store all numbers in a map
            for each number, check if x - 1 is in the map, add number of occurance of x - 1 to the count
        */
//         HashMap<Integer, Integer> map = new HashMap<>();
        
//         for (int i : arr) {
//             map.put(i, map.getOrDefault(i, 0) + 1);
//         }
        
//         int count = 0;
//         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//             if (map.containsKey(entry.getKey() - 1)) {
//                 count += map.get(entry.getKey() - 1);
//             }
//         }
//         return count;
        
        
        /*
            Method 2
            sort the array and count the duplicate numbers, add the countnum to count if number + 1 is also in the array
        */
        Arrays.sort(arr);
        int count = 0, countnum = 1;
        
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i - 1] == arr[i] - 1) {
                count += countnum;
                countnum = 1;
            } else if (arr[i - 1] == arr[i]) {
                countnum++;
            } else {
                countnum = 1;
            }
        }
        return count;
    }
}