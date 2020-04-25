class Solution {
    /*
        BackTracking
    */
    int ans = Integer.MAX_VALUE / 2, tar = 0;
    public int threeSumClosest(int[] nums, int target) {
        tar = target;
        helper(nums, 0, 0, 0);
        return ans;
    }
    
    private void helper(int[] nums, int sum, int start, int number) {
        if (number == 3) {
            //long var = Math.abs(ans - tar);
            //System.out.println(var + " " + Math.abs(sum - tar));
            if (Math.abs(ans - tar) >= Math.abs(sum - tar)) {
                //System.out.println(var + " " + Math.abs(sum - tar));
                ans = sum;
            }
        }
        else {
            for (int i = start; i < nums.length; ++i) {
                helper(nums, sum + nums[i], i + 1, number + 1);
            }
        }
    }
}