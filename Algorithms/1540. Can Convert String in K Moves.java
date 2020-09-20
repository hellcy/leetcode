class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) return false;
        int[] array = new int[s.length()];
        
        for (int i = 0; i < array.length; ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            array[i] = c2 - c1 >= 0 ? c2 - c1 : c2 - c1 + 26;
        }
        
        int maxNumber = 0, times = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i :  array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for (int key : map.keySet()) {
            if (key == 0) continue;
            int currentTime = map.get(key);
            if (currentTime >= times) {
                if (currentTime == times) {
                    maxNumber = Math.max(maxNumber, key);
                } else {
                    maxNumber = key;
                }
                times = currentTime;
            }
        }
                //System.out.println(map);

        //System.out.println(times +" " + maxNumber);
        return k >= (times - 1) * 26 + maxNumber;
    }
}