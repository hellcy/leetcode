class Solution {
    public String reverseWords(String a) {
        /*
            StringBuilder reverse
        */
//         String ans = "";
//         String[] array = a.split(" ");
//         for (String s : array) {
//             StringBuilder str = new StringBuilder(s);
//             str = str.reverse();
//             ans += str + " ";
//         }
        
//         return ans.substring(0, ans.length() - 1);
        
        
        /*
            Use Char array and write your own reverse function
        */
        String ans = "";
        String[] array = a.split(" ");
        for (String s : array) {
            ans += reverse(s) + " ";
        }
        
        return ans.substring(0, ans.length() - 1);
    }
    
    private String reverse(String str) {
        char[] array = str.toCharArray();
        int low = 0;
        int high = str.length() - 1;
        
        while (low < high) {
            char temp = array[low];
            array[low] = array[high];
            array[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(array);
    }
}