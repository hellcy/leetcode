class Solution {
    public int distributeCandies(int[] candies) {
        /*
            HashSet
                add each kind of candies to the set
                sister can get at most the minimum number between half of the size of the array, and size of the set
        */
        Set<Integer> set = new HashSet<>();
        for (int i : candies) {
            set.add(i);a
        }
        
        int length = candies.length / 2;
        return Math.min(length, set.size());
    }
}