class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        String[] words = text.split(" ");
        Set<Character> letters = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            letters.add(c);
        }
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            boolean found = false;
            for (char c : chars) {
                if (letters.contains(c)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;
            }
        }
        
        return count;
    }
}