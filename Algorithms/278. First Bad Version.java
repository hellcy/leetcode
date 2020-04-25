/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        /*
            Binary Search 
                similar to question 374. Guess Number Higher or Lower
        */
//         int low = 1;
//         int high = n;
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             boolean check = isBadVersion(mid);
//             if (check) {
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
        
//         return low;
        
        /*
            Ternary Search
                In general, tenary search doesn't have any advantage against binary search
                it does perform less interations, but it does more comparsion on each interation,
                which result in more comparsions in total than binary search
        */
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid1 = low + (high - low) / 3;
            int mid2 = high - (high - low) / 3;
            boolean check1 = isBadVersion(mid1);
            boolean check2 = isBadVersion(mid2);
            if (check1) {
                high = mid1 - 1;
            } else if (check2 && !check1) {
                high = mid2 - 1;
                low = mid1 + 1;
            } else if (!check2) {
                low = mid2 + 1;
            }
        }
        return low;
    }
}