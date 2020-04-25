/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /*
        Binary Search
            To prevent mid from exceed the max value of int,
            we use low + (high - low) / 2 instead of (low + high) / 2
    */
    // public int guessNumber(int n) {
    //     int low = 1;
    //     int high = n;
    //     while (low <= high) {
    //         int mid = low + (high - low) / 2;
    //         //System.out.println(mid);
    //         int g = guess(mid);
    //         if (g == -1) {
    //             high = mid - 1;
    //         } else if (g == 1) {
    //             low = mid + 1;
    //         } else {
    //             return mid;
    //         }
    //     }
    //     return low;
    // }
    
    /*
        Ternary Search
            In Binary Search, we choose the middle element as the pivot in splitting. 
            In Ternary Search, we choose two pivots (say m1m1 and m2m2) 
            such that the given range is divided into three equal parts. 
            If the required number numnum is less than m1m1 then we apply ternary search on the left segment of m1m1. 
            If numnum lies between m1m1 and m2m2, we apply ternary search between m1m1 and m2m2. 
            Otherwise we will search in the segment right to m2m2.
    */
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            int g1 = guess(mid1);
            int g2 = guess(mid2);
            if (g1 == 0) return mid1;
            else if (g2 == 0) return mid2;
            else if (g1 == -1) high = mid1 - 1;
            else if (g2 == 1) low = mid2 + 1;
            else if (g1 == 1 && g2 == -1) {
                low = mid1 + 1;
                high = mid2 - 1;
            }
        }
        return low;
    }
}