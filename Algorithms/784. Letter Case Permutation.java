class Solution {
    Set<String> set = new HashSet<>();
    /*
        Backtracking
            for each character, we call helper twice for lowercase and uppercase
            for digits, we append it and continue to next round
    */
    public List<String> letterCasePermutation(String S) {
        
        helper("", S);
        List<String> list = new ArrayList<>();
        
        for (String s : set) {
            list.add(s);
        }
        
        return list;
    }
    
    private void helper(String combination, String s) {
        if (s.length() == 0) {
            set.add(combination);
            return;
        }
    
        if (s.charAt(0) < 65) {
            helper(combination + s.substring(0, 1), s.substring(1));
        } else {
            if (s.charAt(0) < 97) {
                helper(combination + String.valueOf((char)(s.charAt(0) - 'A' + 'a')), s.substring(1));
            } else {
                helper(combination + String.valueOf((char)(s.charAt(0) - 'a' + 'A')), s.substring(1));
            }
            helper(combination + s.substring(0, 1), s.substring(1));
        }
    }
}