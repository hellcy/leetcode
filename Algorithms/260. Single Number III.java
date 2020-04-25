class Solution {
    public int[] singleNumber(int[] nums) {
        /*
            HashMap
                store times of appearance into a map
                find all values that only appear one time and return the array
        */
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int[] array = new int[2];
        int index = 0;
        for (int i : map.keySet()) {
            if (map.get(i) == 1 && index == 0) {
                array[0] = i;
                index++;
            } else if (map.get(i) == 1 && index == 1) {
                array[1] = i;
                break;
            }
        }
        
        return array;
        /*
            TODO: try using bit manipulation without using extra memory
        */
    }
}