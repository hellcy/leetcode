class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        /*
            HashMap
                store the order information into a map
                for each string, check order with its next string
                continue check next character only if the current character are equal
        */
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); ++i) {
            map.put(order.charAt(i), i);
        }
        
        for (int i = 0; i < words.length - 1; ++i) {
            boolean flag = true;
            int length = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < length; ++j) {
                if (map.get(words[i].charAt(j)) > map.get(words[i + 1].charAt(j))) return false;
                else if (map.get(words[i].charAt(j)) < map.get(words[i + 1].charAt(j))) {
                    flag = false;
                    break;
                }
            }
            if (flag && words[i].length() > words[i + 1].length()) return false;
        }
        
        return true;
    }
}