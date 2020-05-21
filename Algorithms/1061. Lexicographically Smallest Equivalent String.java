class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        /*
            Union find
            group different characters into groups, make sure the parent characters are the smallest
            replace each character in S with the smallest character using Find()
        */
        
        char[] array = new char[26];
        for (char c = 'a'; c <= 'z'; ++c) {
            array[c - 'a'] = c;
        }
        
        for (int i = 0; i < A.length(); ++i) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            
            char root_a = find(array, a);
            char root_b = find(array, b);
            if (root_a != root_b) {
                if (root_a < root_b) array[root_b - 'a'] = root_a;
                else array[root_a - 'a'] = root_b;
            }
        }
        
        StringBuilder ans = new StringBuilder();
        for (char c : S.toCharArray()) {
            ans.append(find(array, c));
        }
        return ans.toString();
    }
    
    private char find(char[] array, char x) {
        if (array[x - 'a'] == x) {
            return x;
        }
        return array[x - 'a'] = find(array, array[x - 'a']);
    }
}