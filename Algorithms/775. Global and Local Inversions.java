/*
 * @lc app=leetcode id=775 lang=java
 *
 * [775] Global and Local Inversions
 */

// @lc code=start
class Solution {
    public boolean isIdealPermutation(int[] A) {
        /*
            if it is local inversion, it is also a global inversion

            find if there exists a global inversion that is not local inversion
        */

        // int n = A.length;
        // for (int i = 0; i < n; ++i) {
        //     for (int j = i + 2; j < n; ++j) {
        //         if (A[i] > A[j]) return false;
        //     }
        // }

        // return true;

        /*
            Better solution
            The idea is that anytime a number is misplaced from its position in sorted array by more than one step, it will add more to global inversions than to local inversion.
            Example:
            If, A[i] - i = 2,

            So, there must atleast be 2 elements(let's say, A[x] and A[y]) in array for which,
            A[i] > A[x], x > i
            A[i] > A[y], y > i

            And as both cannot be adjacent to A[i], so, global inversion is increased by atleast 2 due to this, while local inversion is increased by just 1.
        */

        for(int i=0;i<A.length;i++){
            if(Math.abs(A[i] - i) > 1){
                return false;
            }    
        }
        return true;
    }
}
// @lc code=end

