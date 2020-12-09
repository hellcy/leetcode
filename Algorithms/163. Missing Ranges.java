class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int start = lower;
        int index = 0;
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            if (num != start) {
                if (start != num - 1) list.add(start + "->" + (num - 1));
                else list.add(String.valueOf(start));
            }

            start = num + 1;
        }

        if (start <= upper) {
            if (start != upper) list.add(start + "->" + upper);
            else list.add(String.valueOf(start));
        }

        return list;
    }
}