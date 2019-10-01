class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        /*
            Array
            HashSet
        */
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet<>();
        for (String s : words) {
            char[] cs = s.toCharArray();
            String temp = "";
            for (char c : cs) {
                temp += code[c - 'a'];
            }
            set.add(temp);
        }
        return set.size();
    }
}