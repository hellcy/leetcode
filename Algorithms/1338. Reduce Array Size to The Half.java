class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int[] array = new int[map.size()];
        int index = 0;
        for (int key : map.keySet()) {
            array[index] = map.get(key);
            index++;
        }
        
        int n = arr.length;
        
        int target = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        Arrays.sort(array);
        
        // for (int i : array) {
        //     System.out.print(i + " ");
        // }
        
        int count = 0;
        index = array.length - 1;
        int ans = 0;
        while (count < target) {
            count += array[index];
            index--;
            ans++;
        }
        
        return ans;
    }
}