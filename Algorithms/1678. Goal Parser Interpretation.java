class Solution {
    public String interpret(String command) {
        for (int i = 1; i < command.length(); ++i) {
            char c = command.charAt(i);
            char prev = command.charAt(i - 1);
            if (c == ')') {
                if (prev == '(') {
                    command = command.substring(0, i - 1) + "o" + command.substring(i + 1);
                    i--;
                } else {
                    command = command.substring(0, i - 3) + "al" + command.substring(i + 1);
                    i -= 3;
                }
            }
        }
        return command;
    }
}