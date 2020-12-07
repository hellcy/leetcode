class Solution {
    public String reorganizeString(String S) {
        /*
            Similar to question 1054
            1. find the character with max time of occurance
            2. rearrange the other chars in order: 
                e.g. aaaaabbbcce
                take out 'a', bbbcce is left
                rearrage to: bcebcb
                put a back from right to left: bcaeabacaba
        */
        Map<Character, Integer> map = new HashMap<>();
        char[] cs = S.toCharArray();

        for (char c : cs) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0, total = 0;
        char maxc = 'a';
        for (char key : map.keySet()) {
            int num = map.get(key);
            total += num;
            if (num > max) {
                max = num;
                maxc = key;
            }
        }

        if (max > total - max + 1) return "";
        map.remove(maxc);

        StringBuilder str = new StringBuilder();
        while (map.size() > 0) {
            Set<Character> set = new HashSet<>();
            for (char key : map.keySet()) {
                str.append(key);
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) set.add(key);
            }

            for (char key : set) {
                map.remove(key);
            }
        }
        
        System.out.println(str.toString());

        int index = str.length();
        while (max > 0) {
            str.insert(index, maxc);
            index--;
            max--;
        }
        return str.toString();
    }
}