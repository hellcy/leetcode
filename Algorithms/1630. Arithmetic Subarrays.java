class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        
        int m = l.length;
        for (int i = 0; i < m; ++i) {
            ans.add(helper(nums, l[i], r[i]));
        }
        
        return ans;
    }
    
    private boolean helper(int[] nums, int start, int end) {
        int[] temp = new int[end - start + 1];
        if (temp.length <= 2) return true;
        for (int i = start; i <= end; ++i) {
            temp[i - start] = nums[i]; 
        }
        
        Arrays.sort(temp);
        
        int diff = temp[1] - temp[0];
        for (int i = 2; i < temp.length; ++i) {
            if (diff != temp[i] - temp[i - 1]) return false;
        }
        
        return true;
    }
}