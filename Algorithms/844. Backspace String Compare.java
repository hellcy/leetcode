class Solution {
    public boolean backspaceCompare(String S, String T) {
        /*
            Stack
            Time O(n)
            Space O(n)
        */
        // Stack<Character> stack1 = new Stack<>();
        // Stack<Character> stack2 = new Stack<>();

        // char[] ss = S.toCharArray();
        // char[] ts = T.toCharArray();
        
        // for (char c : ss) {
        //     if (c != '#') {
        //         stack1.push(c);
        //     } else if (!stack1.empty()) {
        //         stack1.pop();
        //     }
        // }
        
        // for (char c : ts) {
        //     if (c != '#') {
        //         stack2.push(c);
        //     } else if (!stack2.empty()) {
        //         stack2.pop();
        //     }
        // }
        
        // //System.out.println(stack1.size());
        // if (stack1.size() != stack2.size()) return false;
        // while (!stack1.empty()) {
        //     if (stack1.pop() != stack2.pop()) return false;
        // }
        
        // return true;

        /*
			iterate Strings backwards, keep track of the next (not # and not skip) character
			check if they are equal
			Time O(n)
			Space O(1)
        */
        int skip1 = 0, skip2 = 0;
        int index1 = S.length() - 1, index2 = T.length() - 1;
        
        while (index1 >= 0 || index2 >= 0) {
            while (index1 >= 0 && (S.charAt(index1) == '#' || skip1 > 0)) {
                if (S.charAt(index1) == '#') {
                    skip1++;
                    index1--;
                } else {
                    skip1--;
                    index1--;
                }
            }
            
            while (index2 >= 0 && (T.charAt(index2) == '#' || skip2 > 0)) {
                if (T.charAt(index2) == '#') {
                    skip2++;
                    index2--;
                } else {
                    skip2--;
                    index2--;
                }
            }
            
            if (index1 < 0 && index2 >= 0) return false;
            if (index2 < 0 && index1 >= 0) return false;
            if (index1 < 0 && index2 < 0) return true;
            if (S.charAt(index1) != T.charAt(index2)) return false;
            
            index1--;
            index2--;
        }
        
        return true;
    }
}