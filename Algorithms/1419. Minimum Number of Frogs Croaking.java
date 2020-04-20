class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        /*
            Use a hashmap to store the next letter each frog is expecting
        */
        if (croakOfFrogs.length() % 5 != 0) return -1;
        
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Character> nextletter = new HashMap<>();
        nextletter.put('c', 'r');
        nextletter.put('r', 'o');
        nextletter.put('o', 'a');
        nextletter.put('a', 'k');        
        
        int max = 0, count = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            if (map.size() == 0) {
                map.put('r', 1);
                count++;
                if (count > max) max = count;
            } else {
                boolean found = false;
                for (int i = 0; i < map.size(); ++i) {
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) - 1);
                        count--;
                        if (c != 'k') {
                            char next = nextletter.get(c);
                            map.put(next, map.getOrDefault(next, 0) + 1);
                            count++;
                        }
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    if (c != 'c') return -1;
                    map.put('r', 1);
                    count++;
                    
                    if (count > max) max = count;
                }
            }
        }
        
        for (char c : map.keySet()) {
            if (map.get(c) > 0) return -1;
        }
        
        return max;
    }
}