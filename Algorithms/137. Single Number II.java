class Solution {
    public int singleNumber(int[] nums) {
        /*
            HashSet
                3 * sum of set - sum of nums = 2 * our target value
        */
        long sum = 0;
        long setSum = 0;
        for (int i : nums) {
            sum += i;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : set) {
            //System.out.println(i);
            setSum += i;
        }
        return (int)((setSum * 3 - sum) / 2);
    }
}