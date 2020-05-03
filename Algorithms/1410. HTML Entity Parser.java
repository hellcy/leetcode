class Solution {
    public String entityParser(String text) {
        /*
            brute force
            when & appears, keep track of the next some characters see if they match the parser.
            append correct symbol to the ans text
        */
        StringBuilder ans = new StringBuilder();
        StringBuilder match = new StringBuilder();
        
        Map<String, String> map = new HashMap<>();
        
        map.put("&quot;", "\"");
        map.put("&apos;", "\'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        //System.out.println(map.get("&apos;"));
        
        int slow = 0, fast = 0;
        boolean start = false;
        for (int i = 0; i < text.length(); ++i) {
            char c = text.charAt(i);
            if (c == '&') {
                start = true;
                match = new StringBuilder();
            }
            if (start) match.append(c);
            ans.append(c);
            if (map.containsKey(match.toString())) {
                ans.delete(ans.length() - match.length(), ans.length());
                ans.append(map.get(match.toString()));
                match = new StringBuilder();
                start = false;
            }
        }
        
        return ans.toString();
    }
}