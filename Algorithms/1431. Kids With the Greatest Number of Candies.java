class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        /*
            add extraCandies to each kid, if greater then max, add true to the list
        */
        int max = 0;
        for (int i : candies) {
            if (i > max) max = i;
        }
        
        List<Boolean> list = new ArrayList<>();
        for (int i : candies) {
            if (i + extraCandies >= max) list.add(true);
            else list.add(false);
        }
        
        return list;
    }
}