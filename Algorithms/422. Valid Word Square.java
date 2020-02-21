class Solution {
    public boolean validWordSquare(List<String> words) {
        /*
            matrix
            double for loop
        */
        for (int i = 0; i < words.size(); ++i) {
            String str = words.get(i);
            
            for (int j = 0; j < str.length(); ++j) {
                if (j >= words.size() || i >= words.get(j).length() || str.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}