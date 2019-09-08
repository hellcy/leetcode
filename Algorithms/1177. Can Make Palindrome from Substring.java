class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        /*
            Algorithm explained:
                we know there are only 26 characters in the English alphabet,
                which means if k is equal to or greater than 13, we can definately make it to palindrome
                otherwise, we keep track of the number of appearance of each character, 
                and add character to the set only if the appearance time is odd.
                if distinctive character is more than 2 * k, return false
        */
        int n = queries.length;
        List<Boolean> array = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (queries[i][2] >= 13) {
                array.add(true);
                continue;
            }
            String substring = s.substring(queries[i][0], queries[i][1] + 1);
            array.add(check(substring, queries[i][2]));
        }
        
        return array;
    }
    
    private boolean check(String s, int k) {
        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < array.length; ++i) {
            if (set.contains(array[i])) {
                set.remove(array[i]);
            } else {
                set.add(array[i]);
            }
        }
        
        return set.size() / 2 <= k;
    }
}