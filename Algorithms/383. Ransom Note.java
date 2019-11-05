class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
            StringBuilder
            String
        */
        StringBuilder str = new StringBuilder(magazine);
        boolean check = true;
        for (int i = 0; i < ransomNote.length(); ++i) {
            check = true;
            for (int j = 0; j < str.length(); ++j) {
                //System.out.println(ransomNote.charAt(i) + " " + str.charAt(j));
                if (ransomNote.charAt(i) == str.charAt(j)) {
                    str.deleteCharAt(j);
                    check = false;
                    break;
                }
            }
            if (check) return false;
        }
        return true;
    }
}