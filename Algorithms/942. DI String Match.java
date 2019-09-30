class Solution {
    public int[] diStringMatch(String S) {
        /*
            Math
                For each character in S
                if it is 'I', we add the smallest number to the array and let small++,
                if it is 'D', we add the larest number to the array and let large--,
                then deal with the last character.
        */
        int n = S.length();
        int low = 0;
        int high = S.length();
        
        int[] array = new int[high + 1];
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == 'I') {
                //System.out.println(i + " " + low);
                array[i] = low;
                low++;
            } else {
                array[i] = high;
                high--;
            }
        }
        if (S.charAt(n - 1) == 'I') array[n] = low;
        else array[n] = high;
        
        return array;
    }
}