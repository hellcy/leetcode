class Solution {
    List<String> ans = new ArrayList<>();
    int length = 0;
    public List<String> generateParenthesis(int n) {
        /*
            Recursion
            Backtracking
                Note: local variable and global variable
        */
        length = n * 2;
        int count = 0, left = n, right = n;
        helper("", count, left, right);
        return ans;
    }
    
    private void helper(String combination, int count, int left, int right) {
        //System.out.println(combination + " " + count + " " + left + " " + right);
        if (combination.length() == length) {
            ans.add(combination);
            return;
        }
        
        if (count == 0 && left > 0) {
            count++;
            left--;
            helper(combination + "(", count, left, right);
        } else {
            if (left > 0) {
                /*
                    in here, if we directly modify count and left instead of using local variables
                    the other if case will be affected, we want them to be independent
                */
                int localcount = count + 1;
                int localleft = left - 1;
                helper(combination + "(", localcount, localleft, right);
            }
            if (right > 0) {
                count--;
                right--;
                helper(combination + ")", count, left, right);
            }
        }
    }
}