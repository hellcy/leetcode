class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        /*
            BFS
        */
        
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        visited.add(s);
        String ans = s;
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            String temp1 = op1(cur, a);
            String temp2 = op2(cur, b);
            if (!visited.contains(temp1)) {
                queue.add(temp1);
                visited.add(temp1);
                ans = helper(ans, temp1);
            }
            if (!visited.contains(temp2)) {
                queue.add(temp2);
                visited.add(temp2);
                ans = helper(ans, temp2);
            }
            //System.out.println(cur + " " + temp2 + " " + temp1);
        }
        return ans;
    }
    
    private String op1(String s, int a) {
        String str = "";
        
        for (int i = 0; i < s.length(); ++i) {
            if (i % 2 == 0) {
                str += s.substring(i, i + 1);
            } else {
                int num = Integer.valueOf(s.substring(i, i + 1));
                num += a;
                while (num >= 10) {
                    num -= 10;
                }
                str += Integer.toString(num);
            }
        }
        
        return str;
    }
    
    private String op2(String s, int b) {
        return reverse(reverse(s.substring(0, s.length() - b)) + reverse(s.substring(s.length() - b)));
    }
    
    private String reverse(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            str += s.substring(i, i + 1);
        }
        
        return str;
    }
    
    private String helper(String a, String b) {
        for (int i = 0; i < a.length(); ++i) {
            char ac = a.charAt(i);
            char bc = b.charAt(i);
            if (ac < bc) return a;
            else if (ac > bc) return b;
        }
        
        throw null;
    }
}