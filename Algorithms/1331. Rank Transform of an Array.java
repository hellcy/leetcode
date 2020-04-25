class Solution {
    public int[] arrayRankTransform(int[] arr) {
        /*
            HashMap
            Array
                Use another array and sort it to get the ranks
                Store the ranks in a hashmap
        */
        if (arr.length == 0) return new int[] {};
        int[] array = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            array[i] = arr[i];
            map.put(arr[i], 0);
        }
        
        Arrays.sort(array);
        int rank = 1;
        map.put(array[0], rank);
        for (int i = 1; i < arr.length; ++i) {
            if (array[i - 1] != array[i]) rank++;
            map.put(array[i], rank);
        }
        //System.out.println(map);
        int[] ans = new int[arr.length];
        
        int count = 0;
        for (int i : arr) {
            ans[count] = map.get(i);
            count++;
        }
        
        return ans;
    }
}