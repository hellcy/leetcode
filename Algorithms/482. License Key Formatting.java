class Solution {
    public String licenseKeyFormatting(String S, int K) {
        /*
            StringBuilder
            String
            Character
        */
        StringBuilder str = new StringBuilder();
        
        S = S.replaceAll("\\-", "");
                
        int count = 0;
        for (int i = S.length() - 1; i >= 0; --i) {
            if (count < K) {
                str.append(Character.toUpperCase(S.charAt(i)));
                count++;
            } else {
                str.append('-');
                count = 0;
                i++;
            }
        }
        str = str.reverse();
        //System.out.println(str);
        return str.toString();
    }
}