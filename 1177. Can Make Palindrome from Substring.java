class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        /*
            Algorithm explained:
                we know there are only 26 characters in the English alphabet,
                which means if k is equal to or greater than 13, we can definately make it to palindrome
                otherwise, we keep track of the number of appearance of each character, 
                and add 1 to count only if the appearance time is odd.
                if distinctive character is more than 2 * k, return false
        */
        int n = queries.length;
        List<Boolean> array = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            String subString = s.substring(queries[i][0], queries[i][1] + 1);
            if (queries[i][2] >= 13) { 
                array.add(true);
                continue;
            }
            array.add(check(subString, queries[i][2]));
        }
        
        return array;
    }
    
    private boolean check(String s, int k) {
        int count = 0;
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; ++i) {
            if (map.containsKey(array[i])) {
                map.remove(array[i]);
                count--;
            } else {
                map.put(array[i], 1);
                count++;
            }
        } 

        if (count / 2 <= k) return true;
        return false;
    }
}