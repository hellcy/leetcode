class Solution {
    /*
        Recursion
    */
    List<String> ans = new ArrayList<>();
    Map<Integer, String> map = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return ans;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        
        helper("", digits);
        return ans;
    }
    
    private void helper(String combination, String digit) {
        if (digit.length() == 0) {
            ans.add(combination);
            return;
        }
        
        String next_digit = digit.substring(0,1);
        String letters = map.get(Integer.valueOf(next_digit));
        digit = digit.substring(1);
        for (int i = 0; i < letters.length(); ++i) {
            helper(combination + letters.substring(i, i + 1), digit);
        }
    }
}