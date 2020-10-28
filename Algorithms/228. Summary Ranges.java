class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return list;
        int start = nums[0], prev = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i] == prev + 1) {
                prev = nums[i];
            } else {
                StringBuilder str = new StringBuilder();
                str.append(start);
                if (start != prev) {
                    str.append("->");
                    str.append(prev);   
                }
                list.add(str.toString());
                
                start = nums[i];
                prev = nums[i];
            }
        }
        
        StringBuilder str = new StringBuilder();
        str.append(start);
        if (start != prev) {
            str.append("->");
            str.append(prev);   
        }
        list.add(str.toString());
        
        return list;
    }
}