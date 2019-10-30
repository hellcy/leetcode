class Solution {
    /*
        Backtracking
            combine number together
    */
    List<String> list = new ArrayList<>();
    public List<String> generateAbbreviations(String word) {
        helper("", word);
        return list;
    }
    
    private void helper(String s, String word) {
        if (word.length() == 0) {
            list.add(s);
            return;
        }
        
        if (s.length() > 0 && s.charAt(s.length() - 1) < 65) {
            int number = s.charAt(s.length() - 1) - '0';
            number++;
            helper(s.substring(0, s.length() - 1) + String.valueOf(number), word.substring(1));
        } else {
            helper(s + "1", word.substring(1));
        }
        helper(s + word.substring(0, 1), word.substring(1));
        
    }
}