class Solution {
    /*
        这道题和Subset的区别是可以有重复
        我们同样用Backtracking找到所有的子集，但是其中有一些子集是重复的，比如 {1，2，2}这个例子，会生成两个{1，2}的子集
        所以我们需要判断，当有多个2存在时，我们添加前n个连续的2
        这需要先Sort array
        然后在把数字加到list之前，判断他是否和之前的数字相等，如果相等，但是之前的数字却没有被加到list中，我们则忽略这次运算
        
        如何判断之前的数字是否已经在list中呢？如果start == i，那么这是这次for loop的第一次运算，之前的数肯定被加进来了
        相反如果i > start，我们可能remove过之前的数
        如果被remove掉的数和当前要加进去的数相等，我们忽略这次运算
    */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0 || nums == null) return lists;
        
        Arrays.sort(nums);
        
        List<Integer> list = new ArrayList<>();
        helper(list, 0, nums);
        return lists;
    }
    
    private void helper(List<Integer> list, int start, int[] nums) {
        lists.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1] && i > start) continue;
            list.add(nums[i]);
            helper(list, i + 1, nums);
            list.remove(list.size() - 1);
        }
    }
}