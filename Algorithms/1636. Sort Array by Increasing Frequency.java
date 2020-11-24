class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        Map<Integer, List<Integer>> map2 = new HashMap<>();
        
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (!map2.containsKey(freq)) {
                List<Integer> list = new ArrayList<>();
                list.add(key);
                map2.put(freq, list);
            } else {
                List<Integer> temp = map2.get(freq);
                temp.add(key);
                Collections.sort(temp, (x, y) -> y - x);
            }
        }
        
        int[] ans = new int[nums.length];
        int[] freqs = new int[map2.size()];
        int index = 0;
        for (int freq : map2.keySet()) {
            freqs[index] = freq;
            index++;
        }
        
        Arrays.sort(freqs);
        index = 0;
        for (int j = 0; j < freqs.length; ++j) {
            List<Integer> temp = map2.get(freqs[j]);
            for (int i : temp) {
                for (int k = 0; k < freqs[j]; ++k) {
                    ans[index] = i;
                    index++;
                }
            }
        }
        
        return ans;
    }
}