/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    int max = 1;
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {        
        helper(nestedList, 1);
        
        helper2(nestedList, max);
        return sum;
    }
    
    private void helper(List<NestedInteger> nestedList, int depth) {
        max = Math.max(max, depth);
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) continue;
            else {
                helper(nestedInteger.getList(), depth + 1);     
            }
        }
    }
    
    private void helper2(List<NestedInteger> nestedList, int depth) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                sum += depth * nestedInteger.getInteger();
            } else {
                helper2(nestedInteger.getList(), depth - 1);
            }
        }
    }
}