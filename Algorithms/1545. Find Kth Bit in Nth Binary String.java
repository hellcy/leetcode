class Solution {
    public char findKthBit(int n, int k) {
        String ans = "0";
        for (int i = 1; i < n; ++i) {
            ans = ans + "1" + helper(ans);
            //System.out.println(array[i]);
        }
        
        return ans.charAt(k - 1);
    }
    
    // invert and reverse
    private String helper(String s) {        
        s = s.replace('0', '2');
        s = s.replace('1', '0');
        s = s.replace('2', '1');
        
        return new StringBuilder(s).reverse().toString();
    }
}