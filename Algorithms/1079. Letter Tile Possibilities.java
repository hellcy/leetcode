class Solution {
    /*
        Backtracking
            add combinations to a set prevent duplicates
    */
    Set<String> set = new HashSet<>();
    int count = 0;
    public int numTilePossibilities(String tiles) {
        helper("", tiles);
        //System.out.println(set);
        return set.size();
    }
    
    private void helper(String combination, String tiles) {
        //System.out.println(combination + " " + tiles);
        if (combination != "") set.add(combination);
        if (tiles.length() == 0) {
            return;
        }
        
        for (int i = 0; i < tiles.length(); ++i) {
            helper(combination + tiles.substring(i, i + 1), tiles.substring(0, i) + tiles.substring(i + 1));
        }
    }
}