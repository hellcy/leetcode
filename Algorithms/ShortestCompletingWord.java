class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        /*
            HashMap
                For each string
                check if it contains all characters from licenseplate
                if yes, save its length, compare with the current min
                return valid string with min length
        */
        Map<Character, Integer> map =  new HashMap<>();
        
        int min = Integer.MAX_VALUE;
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); ++i) {
            if (licensePlate.charAt(i) >= 'A') {
                map.put(licensePlate.charAt(i), map.getOrDefault(licensePlate.charAt(i), 0) + 1);
            }
        }
        String ans = "";
        for (String s : words) {
            Map<Character, Integer> smap = new HashMap<>();
            
            for (int i = 0; i < s.length(); ++i) {
                if (map.containsKey(s.charAt(i))) {
                    smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);
                }
            }
            boolean flag = true;
            for (Character c : map.keySet()) {
                if (smap.getOrDefault(c, 0) < map.get(c)) flag = false;
            }
            if (flag && min > s.length()) {
                min = s.length();
                ans = s;
            }
        }
        return ans;
    }
}