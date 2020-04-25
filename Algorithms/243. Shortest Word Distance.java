class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        /*
            Brute force
                for each word equals to word1
                    find all word2 and calculate the min distance
        */
//         int distance = Integer.MAX_VALUE;
//         for (int i = 0; i < words.length; ++i) {
//             if (words[i].equals(word1)) {
//                 for (int j = 0; j < words.length; ++j) {
//                     if (words[j].equals(word2)) {
//                         distance = Math.min(distance, Math.abs(i - j));
//                     }
//                 }
//             }
//         }
        
//         return distance;
        
        /*
            Two pointers
                We can greatly improve on the brute-force approach by keeping two indices point1 and point2
                where we store the most recent locations of word1 and word2. 
                Each time we find a new occurrence of one of the words, we do not need to search the entire array for the other word, 
                since we already have the index of its most recent occurrence.
        */
        int point1 = -1;
        int point2 = -1;
        
        int distance = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; ++i) {
            if (words[i].equals(word1)) point1 = i;
            else if (words[i].equals(word2)) point2 = i;
            
            if (point1 != -1 && point2 != -1) {
                distance = Math.min(distance, Math.abs(point1 - point2));
            }
        }
        return distance;
    }
}