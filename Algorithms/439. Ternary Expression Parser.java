class Solution {
    public String parseTernary(String expression) {
        /*
            String
        */
        if (expression.length() == 1) return expression;
        
        int depth = 1, start = 0, end = 0;
        
        
        if (expression.charAt(0) == 'T') {
            start = 2;
            for (int i = 2; i < expression.length(); ++i) {
                if (expression.charAt(i) == '?') {
                    depth++;
                }
                if (expression.charAt(i) == ':') {
                    depth--;
                }
                if (depth == 0) {
                    end = i;
                    break;
                }
            }
        } else {
            for (int i = 2; i < expression.length(); ++i) {
                if (expression.charAt(i) == '?') {
                    depth++;
                }
                if (expression.charAt(i) == ':') {
                    depth--;
                }
                if (depth == 0) {
                    start = i + 1;
                    end = expression.length();
                    break;
                }
            }
        }
        //System.out.println(start + " " + end);
        //System.out.println(expression.substring(start, end));
        return parseTernary(expression.substring(start, end));
    }
}