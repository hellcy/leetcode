class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        /*
            ArrayList
        */
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; ++i) {
            list.add(index[i], nums[i]);
        }
        
        int[] ans = new int[nums.length];
        int pos = 0;
        for (int i : list) {
            ans[pos] = list.get(pos);
            pos++;
        }
        
        return ans;
    }
}