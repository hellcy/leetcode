class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        /*
            Algorithm explained:
                calculate the frequency by putting a String into a 26 sized array, each index represent a character
                the first number not equal to zero is the frequency of the smallest character
                
                then calculate all the frequencies for queries and words, put them into two arrays
                compare the values and add each count to ans array
        */
        int qN = queries.length;
        int wN = words.length;
        
        int[] qF = new int[qN];
        int[] wF = new int[wN];
        for (int i = 0; i < qN; ++i) {
            qF[i] = frequency(queries[i]);
        }
        
        for (int i = 0; i < wN; ++i) {
            wF[i] = frequency(words[i]);
        }
        
        int count = 0;
        int[] ans = new int[qN];
        for (int i = 0; i < qN; ++i) {
            count = 0;
            for (int j = 0; j < wN; ++j) {
                if (qF[i] < wF[j]) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
    
    private int frequency(String s) {
        int[] array = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            array[c - 'a']++;
        }
        
        for (int i = 0; i < 26; ++i) {
            if (array[i] != 0) return array[i];
        }
        return -1;
    }
}