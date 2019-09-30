class Solution {
    public String defangIPaddr(String address) {
        /*
            StringBuilder
        */
        char[] cs = address.toCharArray();
        StringBuilder str = new StringBuilder(address); 
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == '.') {
                str.replace(i, i + 1, "[.]");
                i += 2;
            }
        }
        
        return str.toString();
    }
}