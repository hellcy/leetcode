/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
class Solution {
    Set<List<Integer>> set = new HashSet<>();
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        /*
            Backtracking (Time limit exceed)
        */
//         int x = 1, y = 1;
        
//         helper(x, y, z, customfunction);
//         //System.out.println(set);
//         List<List<Integer>> lists = new ArrayList<>();
//         for (List<Integer> list : set) {
//             lists.add(list);
//         }
//         return lists;
        
        /*
            Brute force
        */
        int x = 1, y = 1, index = 1;
        List<List<Integer>> lists = new ArrayList<>();
        while (true) {
            int number = customfunction.f(x, y);
            if (number < z) {
                x++;
            } else if (number == z) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                lists.add(list);
                y++;
                x = 1;
            } else if (number > z && x == 1) {
                break;
            } else if (number > z) {
                y++;
                x = 1;
            }
        }
        return lists;
    }
    
    private void helper(int x, int y, int z, CustomFunction customfunction) {
        //System.out.println(x + " " + y);
        int number = customfunction.f(x, y);
        if (number > z) {
            return;
        } else if (number == z) {
            List<Integer> list = new ArrayList<>();
            list.add(x);
            list.add(y);
            set.add(list);
            return;
        }
        
        helper(x + 1, y, z, customfunction);
        helper(x, y + 1, z, customfunction);
    }
}