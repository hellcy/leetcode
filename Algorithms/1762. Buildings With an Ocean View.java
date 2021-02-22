class Solution {
    public int[] findBuildings(int[] heights) {
        int max = -1;
        List<Integer> list = new ArrayList<>();
        int n = heights.length;
        for (int i = n - 1; i >= 0; --i) {
            if (heights[i] > max) {
                list.add(i);
                max = heights[i];
            }
        }

        int index = list.size() - 1;
        int[] ans = new int[list.size()];
        for (int i : list) {
            ans[index] = i;
            index--;
        }

        return ans;
    }
}