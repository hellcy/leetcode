class Solution {
    public String getSmallestString(int n, int k) {
        /*
            Greedy
            add 'z' to the end
            then add 'a' to the front until space left
            
            concatenate string is slower than using a char array
        */
        char[] cs = new char[n];
        int length = n;
        while (k >= (length - 1) * 1 + 26) {
            length--;
            cs[length] = 'z';
            k -= 26;
        }
        
        int index = length - 1;
        while (length > 1) {
            length--;
            cs[length - 1] = 'a';
            k--;
        }
        
        cs[index] = (char)(k + 'a' - 1);
        return String.copyValueOf(cs);
    }
}