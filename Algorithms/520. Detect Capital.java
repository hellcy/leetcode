class Solution {
    public boolean detectCapitalUse(String word) {
        /*
            String
        */
        char[] array = word.toCharArray();
        
        boolean check = true, checklower = true;
        
        if (array[0] >= 97) {
             for (int i = 1; i < array.length; ++i) {
                if (array[i] < 97) return false;
            }   
        } else {
             for (int i = 1; i < array.length; ++i) {
                if (array[i] >= 97) {
                    check = false;
                } else {
                    checklower = false;
                }
                 if (!checklower && array[i] >= 97) return false;
                 if (!check && array[i] < 97) return false;
            }  
        }
        return true;
    }
}