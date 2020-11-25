class Solution {
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        Stack<Long> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        
        int start = 0;
        for (int i = 0; i < cs.length; ++i) {
            char c = cs[i];
            if (c == ' ') {
                if (start != i) {
                    long num = Long.valueOf(s.substring(start, i));
                    stack1.add(num);
                }
                start = i + 1;
            } else if (c == '+' || c == '-') {
                if (start != i) {
                    long num = Long.valueOf(s.substring(start, i));
                    stack1.add(num);
                }
                stack2.add(c);
                start = i + 1;
            } else if (c == '(') {
                stack2.add(c);
                start = i + 1;
            } else if (c == ')') {
                if (start != i) {
                    long num = Long.valueOf(s.substring(start, i));
                    stack1.add(num);
                }
                Stack<Long> temp1 = new Stack<>();
                Stack<Character> temp2 = new Stack<>();
                //System.out.println(stack1);
                //System.out.println(stack2);
                temp1.add(stack1.pop());
                while (stack2.peek() != '(') {
                    temp1.add(stack1.pop());
                    temp2.add(stack2.pop());
                }
                stack2.pop(); // remove the opening paretheses
                
                while (temp1.size() > 1) {
                    long first = temp1.pop();
                    long second = temp1.pop();
                    char op = temp2.pop();
                    if (op == '+') temp1.add(first + second);
                    else temp1.add(first - second);
                }
                stack1.add(temp1.pop());
                start = i + 1;
            }
        }
        
        if (start < cs.length) stack1.add(Long.valueOf(s.substring(start)));
        
        Stack<Long> temp3 = new Stack<>();
        Stack<Character> temp4 = new Stack<>();

        while (!stack1.isEmpty()) {
            temp3.add(stack1.pop());
        }
        
        while (!stack2.isEmpty()) {
            temp4.add(stack2.pop());
        }
        //System.out.println(temp3);
        //System.out.println(temp4);
        while (temp3.size() > 1) {
            long first = temp3.pop();
            long second = temp3.pop();
            char op = temp4.pop();
            if (op == '+') temp3.add(first + second);
            else temp3.add(first - second);
        }
        
        return temp3.pop().intValue();
    }
}